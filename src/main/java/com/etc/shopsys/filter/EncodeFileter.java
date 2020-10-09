package com.etc.shopsys.filter;

import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @ClassName EncodeFileter
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/06 11:15
 * @Version 1.0
 **/
@WebFilter(filterName = "EncodeFileter",
        urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "encode",value = "UTF-8")
        })
public class EncodeFileter implements Filter {
    private String encode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encode = filterConfig.getInitParameter("encode");
//        System.out.println("过滤器初始化，读取到的字符编码" + encode);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置请求编码格式
        request.setCharacterEncoding(encode);
        // 设置响应编码格式
        response.setCharacterEncoding(encode);
        response.setContentType("text/html;"+ encode);
        // 放行
        chain.doFilter(request, response);
//        System.out.println("编码过滤器已放行");
    }

    @Override
    public void destroy() {
        System.out.println("编码过滤器被销毁");
    }
}
