package com.leesin.activitydemo;

import com.leesin.activitydemo.Api.MailService;
import com.leesin.activitydemo.Api.StudentService;
import com.leesin.activitydemo.Entiy.Student;
import com.leesin.activitydemo.web.DemoAction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitydemoApplicationTests {
    private MockMvc mvc;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MailService mailService;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new DemoAction()).build();
    }
    @Test
    public void getHello() throws Exception {
        String res =  mvc.perform(MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void WriteRedis() throws Exception{
        stringRedisTemplate.opsForValue().set("test", "100",60*10, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
        Assert.assertEquals("100", stringRedisTemplate.opsForValue().get("test"));//断言(关键字)取缓存值判断
        System.out.println("对比成功，继续执行!");
    }

    @Test
    public void testObj() throws Exception {
        Student student = new Student();
        student.setName("wanghui");
        student.setAge(18);
        ValueOperations<String, Student> operations=redisTemplate.opsForValue();
        operations.set("com.neox", student);
//        operations.set("com.neo.f", student,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neox");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

    @Test
    public void getRedis(){
        ValueOperations<String, Student> operations=redisTemplate.opsForValue();
        Student student =  operations.get("com.neox");
        String s = student.getName();
        System.out.println(s);
    }

    @Test
    public void testSimpleMail() throws Exception {
        mailService.SendMail("cuisw@hollycrm.com","test simple mail","hello , 小摩托");
    }

}
