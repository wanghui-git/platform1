package com.leesin.activitydemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherAction {

    @RequestMapping("/dialect")
    public String dialect(){
        return "test";
    }
}
