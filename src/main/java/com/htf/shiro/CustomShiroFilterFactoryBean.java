package com.htf.shiro;

import com.htf.exception.ExceptionResponse;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.filter.mgt.SimpleNamedFilterList;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.util.WebUtils;

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

//    private SessionEntityRepository sessionEntityRepository;

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

                //the 'chain names' in this implementation are actually path patterns defined by the user.  We just use them
                //as the chain name for the FilterChainManager's requirements
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
//                    SessionEntity sdbe = sessionEntityRepository.findOne(uuid);
//					if (sdbe == null) {
//						if (ws.isAuthenticated())
//							ws.logout();
//					} else {
//						if (!ws.isAuthenticated() || !sdbe.getAccount().equals(ws.getPrincipal())) {
//							try {
//								ws.login(new LoginToken(sdbe.getAccount()));
//							} catch (AuthenticationException e) {
//								throw new RuntimeException("Inner error. Failed to login with shiro.");
//							}
//						}
//					}
//                    if (sdbe == null) {
////                        throw new AuthenticationException("uuid is illegal.");
//                    } else {
////                        if (!ws.isAuthenticated() || !sdbe.getAccount().equals(ws.getPrincipal())) {
//                            try {
////                                ws.login(new LoginToken(sdbe.getAccount()));
//                            } catch (AuthenticationException e) {
//                                throw new RuntimeException("Inner error. Failed to login with shiro.");
//                            }
////                        }
//                    }
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
