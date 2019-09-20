package com.leesin.activitydemo;

import com.leesin.activitydemo.Api.StudentService;
import com.leesin.activitydemo.Entiy.Student;
import com.leesin.activitydemo.common.Prop.ReadFile;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.db.DbSchemaCreate;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JunitTest {

    @Autowired
    private StudentService studentService;
    @Rule
    public ActivitiRule activitiRule;

    @Test
    public void Utf()
    {
        String a = ReadFile.getString("DemoName");
        String b= null;
        String c= ReadFile.getString("DemoDate");
        String d= null;
        try {
            b = new String(a.getBytes("ISO-8859-1"), "GBK");
            d = new String(c.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(b+"----"+d);
    }

    @Test
    public void Opti(){
        String A = "A";
        String a = "a";
        if(A.equals(a)){
            System.out.println("1");
        }else{
            System.out.println("2");
        }
    }

    @Test
    public void act(){
        // 创建createStandaloneProcessEngineConfiguration 不会读取任何的外部配置文件
        // 所有属性都要在这个configuration中配置，而且很多属性都有默认值
        ProcessEngineConfiguration p4 = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        System.out.println(p4.getDatabaseSchemaUpdate());
        System.out.println(p4.getDatabaseType());
        System.out.println(p4.getJdbcUrl());
        System.out.println(p4.getMailServerHost());
    }

    @Test
    public void creatData(){
//            // 引擎配置
//            ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//            // 获取流程引擎对象
//            ProcessEngine processEngine=pec.buildProcessEngine();

            ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();

//            HistoryService historyService = activitiRule.getHistoryService();


    }

    public static void main(String[] args) {
        DbSchemaCreate.main(args);
    }

    @Test
    public void InitPro(){
        ProcessEngines.init();
        Map<String, ProcessEngine> map = ProcessEngines.getProcessEngines();
        System.out.println(map.size());
        System.out.println(map.get("default"));
        ProcessEngine p2 = map.get("default");
    }
}



