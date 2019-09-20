package com.leesin.activitydemo.common.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JavaConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter()
    {
        return new RemoteIpFilter();
    }

//    @Bean
//    public FilterRegistrationBean demoFilterRegistrationBean()
//    {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new DemoFilter1());
//        registrationBean.addUrlPatterns("/demo");
//        registrationBean.addInitParameter("param","http:1212.1.3.cn");
//        registrationBean.setName("beanFilter");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

}
