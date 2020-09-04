package com.leesin.activitydemo.web;

import com.leesin.activitydemo.Api.StudentService;
import com.leesin.activitydemo.Entiy.Student;
import org.activiti.engine.*;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("Student")
public class StudentAction {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    @ResponseBody
    public String add()
    {
        String result;
//        Date date = new Date();
        Student student = new Student();
        student.setName("张三");
        student.setAddress("北京");
        student.setAge(26);
        student.setSex("男");
//        student.setCreateTime(date);
//        student.setModifyTime(date);
        result = studentService.save(student);
        return result;
    }

    @RequestMapping("/findById")
//    @Cacheable(value="user-key")
    @ResponseBody
    public Optional<Student> findById()
    {
        long id = 11L;
        Optional<Student> student = studentService.findOne(id);
//        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return student;
    }

    //查询所有学生
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @RequestMapping("/uid")
    @ResponseBody
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @RequestMapping("/initTest")
    @ResponseBody
    public Map<String, ProcessEngine> initTest(){
        Map<String, ProcessEngine> map = ProcessEngines.getProcessEngines();
        System.out.println(map.size());
        System.out.println(map.get("default"));
        ProcessEngine p2 = map.get("default");
        //移除engine
        ProcessEngines.unregister(p2);
        return map;
    }

}
