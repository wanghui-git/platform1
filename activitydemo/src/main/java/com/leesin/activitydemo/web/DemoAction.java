package com.leesin.activitydemo.web;

import com.leesin.activitydemo.common.Prop.ReadFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class DemoAction {

    @RequestMapping("/demo")
    public String demo() {
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
        return b+d;
    }

    @RequestMapping("/false")
    public String False()
    {
        String c = "中文测试i!";
        return c;
    }
}

