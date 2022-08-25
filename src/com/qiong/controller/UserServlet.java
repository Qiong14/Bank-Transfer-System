package com.qiong.controller;

import com.qiong.pojo.User;
import com.qiong.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ServiceMode;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends BaseServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        userService = (UserService) ac.getBean("us");
    }

    public void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        User user=userService.userLoginService(uname,pwd);

        if(user!=null){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }else{
            req.setAttribute("flag","username or password is wrong!");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
