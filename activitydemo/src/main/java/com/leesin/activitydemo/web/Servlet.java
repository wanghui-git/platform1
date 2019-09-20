package com.leesin.activitydemo.web;


import org.activiti.engine.ProcessEngines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Servlet
{
    private static final Logger LOG = LoggerFactory.getLogger(Servlet.class);

    @Bean
    public void logMethod() {
        LOG.info("==========print log==========");
        //初始化方法
        ProcessEngines.init();
        LOG.info("初始化Activiti数据库完毕---！-");
    }
}
