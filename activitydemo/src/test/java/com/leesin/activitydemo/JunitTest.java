package com.leesin.activitydemo;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.leesin.activitydemo.Api.StudentService;
import com.leesin.activitydemo.Entiy.Student;
import com.leesin.activitydemo.common.Prop.ReadFile;
import io.netty.handler.codec.base64.Base64Encoder;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.TimeUnit;

//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JunitTest {

    @Autowired
    private StudentService studentService;
    @Rule
    public ActivitiRule activitiRule;

    private static final Logger log = LoggerFactory.getLogger(JunitTest.class);

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

    public Student get(){
        Student student = new Student();
        student.setName("张三");
        student.setAddress("北京");
        student.setAge(26);
        student.setSex("男");
        return  student;
    }

    @Test
    public void Option(){
//        Optional<String> emptyOpt = Optional.empty();
//        Optional<String> opt =  Optional.of(null);//确定对象值不为空时使用of
//        Optional<String> opt = Optional.ofNullable(null);//对象值可能是null也可能不是null用ofNullable
//        String name = "Jo";
//        Optional<String> opt = Optional.ofNullable(name);
//        Assert.assertEquals("John", opt.get());
//        String o = null;
//        Optional<String> opt = Optional.of(Optional.ofNullable(o).orElse("aa"));
        Student student1 = null;
        Student result = Optional.ofNullable(student1).orElseGet(()-> get());
        log.info(JSON.toJSONString(result));
    }

    @Test
    public void timetest(){
        LocalDate date = LocalDate.now();
        long epochMilli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        log.info(date.toString());
//        log.info(String.valueOf(epochMilli));
        Date dated = new Date();
        Date datede = new Date();
        dated = datede;
        log.debug(dated.toString());
        HashMap<String,String> maps = new HashMap<>(1000);
        Map<String, String> map = Maps.newHashMapWithExpectedSize(10);
        List<String> list = Lists.newArrayListWithExpectedSize(10);
        Set<String> set = Sets.newHashSetWithExpectedSize(10);
        List<Integer> integers = new ArrayList<>(100);


    }

    @Test
    public void MD5Test(){

        String text = "a b {}+_@#$%:><*()";
        byte data[] = null;
        byte resultData[] = null;
        MessageDigest m;
        try {
            data = text.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {}
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(data);
            resultData = m.digest();
        } catch (NoSuchAlgorithmException e) {}
        String res = convertToHexString(resultData);
        System.out.println(res);
        String en = null;
        try {
            en = MD5Encode(res);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("-===="+en);
    }


    static String convertToHexString(byte data[]) {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            strBuffer.append(Integer.toHexString(0xff & data[i]));
        }
        return strBuffer.toString();
    }

    static String MD5Encode(String text) throws UnsupportedEncodingException {
        String en = Base64.getEncoder().encodeToString(text.getBytes("UTF-8"));
        log.debug("-----"+en);
        byte[] de = Base64.getDecoder().decode(en);
        log.debug(new String(de,"UTF-8"));
        return en;    }

}



