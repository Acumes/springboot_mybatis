package com.htf.shiro;

import com.htf.exception.ExceptionResponse;
import com.htf.service.CacheService;
import com.htf.util.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.filter.mgt.SimpleNamedFilterList;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Created by PC-FENG on 2017/8/25.
 */
public class CustomShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    public static final String UUID_HEADER = "uuid";
    private static final Pattern resourceSuffix = Pattern.compile("\\.\\w{1,15}$");

    @Autowired
    private CacheService cacheService;

    @Override
    protected AbstractShiroFilter createInstance() throws Exception {
        // TODO Auto-generated method stub

        FilterChainManager manager = createFilterChainManager();

        // Expose the constructed FilterChainManager by first wrapping
        // it in a
        // FilterChainResolver implementation. The AbstractShiroFilter
        // implementations
        // do not know about FilterChainManagers - only resolvers:
        PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
        chainResolver.setFilterChainManager(manager);

        AbstractShiroFilter filter = new AbstractShiroFilter() {

            protected boolean pathMatches(String pattern, String path) {
                PatternMatcher pathMatcher = chainResolver.getPathMatcher();
                return pathMatcher.matches(pattern, path);
            }

            protected boolean isRequestIgnored(ServletRequest request, ServletResponse response) {
                if (!manager.hasChains()) {
                    return false;
                }

                String requestURI = WebUtils.getPathWithinApplication(WebUtils.toHttp(request));
                SimpleNamedFilterList configuredFilter = null;
                Object anonFilter = null;

                for (String pathPattern : manager.getChainNames()) {

                    // If the path does match, then pass on to the subclass implementation for specific checks:
                    if (pathMatches(pathPattern, requestURI)) {
                        configuredFilter = (SimpleNamedFilterList) manager.getChain(pathPattern);
                        break;
                    }
                }

                if(configuredFilter != null && !configuredFilter.isEmpty()){
                    anonFilter = configuredFilter.get(0);
                }

                if(anonFilter != null && anonFilter instanceof AnonymousFilter){
                    return true;
                }else{
                    HttpServletRequest hsr = (HttpServletRequest) request;
                    // bypass resource
                    if ("GET".equalsIgnoreCase(hsr.getMethod()) && (resourceSuffix.matcher(hsr.getRequestURI()).find() || "/".equals(hsr.getRequestURI()))){
                        return true;
                    }

                    return false;
                }
            }

            @Override
            protected WebSubject createSubject(ServletRequest request, ServletResponse response) {
                WebSubject ws = super.createSubject(request, response);
                if(isRequestIgnored(request,response)){
                    return ws;
                }

                if(request instanceof HttpServletRequest == false){
                    throw new RuntimeException("Inner error. The request is not a HttpServletRequest");
                }

                HttpServletRequest hsr = (HttpServletRequest)request;
                String uuid = hsr.getHeader(UUID_HEADER);
                if (uuid != null && !uuid.isEmpty()) {
                    String cache = cacheService.getValue(uuid);
                    if(cache == null || cache == ""){
                        throw new AuthenticationException("uuid is illegal.");
                    }
                    String cache_uuid = cache.split("_")[0];
                    String userId = cache.split("_")[1];
                    String username = cache.split("_")[2];
                    String password = cache.split("_")[3];
                    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                    if(!cache_uuid.equals(uuid)){
                        throw new AuthenticationException("uuid is illegal.");
                    }
                    try {
                        ws.login(token);
                    } catch (AuthenticationException e) {
                        throw new RuntimeException("Inner error. Failed to login with shiro.");
                    }
                } else {
                    throw new ExceptionResponse("no "+UUID_HEADER+" header assigned");
                }
                return ws;
            }
        };
        filter.setSecurityManager((WebSecurityManager) getSecurityManager());
        filter.setFilterChainResolver(chainResolver);
        return filter;
    }
}
