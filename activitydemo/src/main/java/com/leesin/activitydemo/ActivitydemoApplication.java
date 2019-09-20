package com.leesin.activitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@ServletComponentScan
@SpringBootApplication
@EnableJpaAuditing
//        (exclude= {DataSourceAutoConfiguration.class})
public class ActivitydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitydemoApplication.class, args);
    }

}
