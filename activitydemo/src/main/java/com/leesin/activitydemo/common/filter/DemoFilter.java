package com.leesin.activitydemo.common.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

//urlPatterns        指定资源匹配。例如"/index.jsp"
//                   以目录匹配。例如"/servlet/*"
//                   以后缀名匹配，例如"*.jsp"
//                   通配符，拦截所有web资源。"/*"

//dispatcherTypes      	  FORWARD,//转发的
//                        INCLUDE,//包含在页面的
//                        REQUEST,//请求的
//                        ASYNC,//异步的
//                        ERROR;//出错的
@WebFilter(filterName = "DemoFilter",
        urlPatterns = "/demo`",
        initParams = {
                @WebInitParam(name = "parameter", value = "http://123.123.1.cn")/*这里可以放一些初始化的参数*/
        },
        dispatcherTypes = {DispatcherType.INCLUDE,DispatcherType.REQUEST})

@Order(1)
public class DemoFilter implements Filter {
    private String  filterName;
    private String  parameter;

    public void destroy() {
        System.out.println("销毁过滤器!---"+filterName);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(filterName + "--开始处理!");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        filterName = config.getFilterName();
        parameter  = config.getInitParameter("parameter");

        System.out.println("初始化过滤器！---"+filterName);
        System.out.println("参数：--"+parameter);
    }

}
