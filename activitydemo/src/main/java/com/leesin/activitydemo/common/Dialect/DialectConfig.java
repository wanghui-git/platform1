package com.leesin.activitydemo.common.Dialect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author wh
 * @date 2020/1/3
 */
@Configuration
public class DialectConfig {
    @Bean
    public AuthAuthority authAuthority(){
        System.out.println("实例化方言对象");
        return new AuthAuthority();
    }
}
