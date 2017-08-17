package com.htf.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**
 * Created by PC-FENG on 2017/8/17.
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig implements EnvironmentAware {
    private RelaxedPropertyResolver propertyResolver;
    /**
     * druid初始化
     * @return
     * @throws SQLException
     */
    @Primary //默认数据源
    @Bean(name = "dataSource",destroyMethod = "close")
    public DruidDataSource Construction() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty("url"));
        dataSource.setUsername(propertyResolver.getProperty("username"));
        dataSource.setPassword(propertyResolver.getProperty("password"));
        dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        //配置最大连接
        dataSource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));
        //配置初始连接
        dataSource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));
        //配置最小连接
        dataSource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));
        //连接等待超时时间maxWait
        dataSource.setMaxWait(Integer.valueOf(propertyResolver.getProperty("maxWait")));
        //间隔多久进行检测,关闭空闲连接timeBetweenEvictionRunsMillis
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(propertyResolver.getProperty("timeBetweenEvictionRunsMillis")));
        //一个连接最小生存时间
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("minEvictableIdleTimeMillis")));
        //用来检测是否有效的sql
        dataSource.setValidationQuery(propertyResolver.getProperty("validationQuery"));
        dataSource.setTestWhileIdle(Boolean.valueOf(propertyResolver.getProperty("testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(propertyResolver.getProperty("testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(propertyResolver.getProperty("testOnReturn")));
        //打开PSCache,并指定每个连接的PSCache大小
        dataSource.setPoolPreparedStatements(Boolean.valueOf(propertyResolver.getProperty("poolPreparedStatements")));
        dataSource.setMaxOpenPreparedStatements(Integer.valueOf(propertyResolver.getProperty("maxOpenPreparedStatements")));
        //配置sql监控的filter
        dataSource.setFilters("stat,wall,log4j");
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException("druid datasource init fail");
        }
        return dataSource;
    }

    /**
     * druid监控
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        //reg.addInitParameter("allow", "127.0.0.1");
        //reg.addInitParameter("deny","");
        reg.addInitParameter("loginUsername", "htf");
        reg.addInitParameter("loginPassword", "123456");
        return reg;
    }

    /**
     * druid监控过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }
}
