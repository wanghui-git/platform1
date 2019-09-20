package com.leesin.activitydemo.common.filter;

import javax.servlet.*;
import java.io.IOException;

//@Component
//@Configuration
public class DemoFilter1 implements Filter{

    private String  filterName;
    private String  parameter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterName = filterConfig.getFilterName();
        parameter  = filterConfig.getInitParameter("param");

        System.out.println("初始化过滤器2！---"+filterName);
        System.out.println("参数2：--"+parameter);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(filterName + "--开始处理2!");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器2!---"+filterName);
    }
}
