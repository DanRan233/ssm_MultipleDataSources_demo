package com.wzk.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 12:00
 * @description:
 */
public class LoginFilter implements Filter {
    //实例化一个静态的集合，应当使用map集合，可以通过key来进行判断，无过多循环
    // private static List<String> urls = new ArrayList<>();
    private static Map<String,String> map =new LinkedHashMap<>();
    //静态代码块中向集合中存放所有可以放行的请求或网页地址（不用账号密码即可访问）
    static {
        map.put("/pages/login.html","/pages/login.html");
        map.put("/pages/index.html","/pages/index.html");
        map.put("/pages/register.html","/pages/register.html");
        map.put("/pages/registerTest.html","/pages/registerTest.html");
        map.put("/user/register","/user/register");
        map.put("/pages/index.jsp","/pages/index.jsp");
        map.put("/pages/index.html","/pages/index.html");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * 拦截请求，看看用户是否登陆，如果没有登陆，
     * 则跳转回登录页面，否则就放行
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //注意：ServletRequest是HttpServletRequest父接口,因此需要强转
        //同样，ServletResponse是HttpServletResponse父接口,因此需要强转

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //得到当前页面所在目录下全名称
        String urlPattern = req.getServletPath();
        //得到页面所在服务器的绝对路径
        String path = req.getRequestURI();
        System.out.println(path+"*****"+urlPattern);
        //判断是否在不需要过滤的集合中
        if(urlPattern.equals(map.get(urlPattern))||path.contains(urlPattern)){
            System.out.println(urlPattern+"请求不进行过滤");
            chain.doFilter(request, response);
            return;
        }
        //如果person为null，表示没有登录
        if (req.getSession().getAttribute("userID") == null) {
            res.sendRedirect("index.jsp");
        } else {
            //放行
            chain.doFilter(request, response);
        }
    }

}
