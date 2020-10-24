package com.leesin.activitydemo.web;

import com.leesin.activitydemo.common.Prop.ReadFile;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class DemoAction {

    private static String address = "http://localhost:9099/HelloWorld/sayHelloWorldFrom?wsdl";

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

    //创建客户端访问WSDL接口  Jax的方式
    //提供方 和 调用方需要有关联关系
    /**
     * webservice接口地址
     */
    @GetMapping("/show")
    public String showMsg() {
        try {
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            //添加用户名密码拦截器
            //jaxWsProxyFactoryBean.getOutInterceptors().add(new LoginInterceptor("root","admin"));;
            // 设置接口类型
//            jaxWsProxyFactoryBean.setServiceClass(MyService.class);
            // 创建一个代理接口实现
//            MyService service = (MyService) jaxWsProxyFactoryBean.create();
            // 调用代理接口的方法调用并返回结果
//            return service.sayHello("hello");
            return  null;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}

