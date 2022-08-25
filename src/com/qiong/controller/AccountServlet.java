package com.qiong.controller;

import com.qiong.pojo.Account;
import com.qiong.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends BaseServlet{

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        accountService = (AccountService) ac.getBean("as");
    }

    public void outMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String outId=req.getParameter("outId");
        String outPwd = req.getParameter("outPwd");

        Account account = accountService.accountOutInfoService(outId, outPwd);

        resp.getWriter().write((account!=null)+"");


    }

    public void inMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String outId=req.getParameter("outId");
        String outPwd = req.getParameter("outPwd");
        Double money = Double.valueOf(req.getParameter("money"));

        Account account = accountService.accountMoneyInfoService(outId, outPwd, money);

        resp.getWriter().write((account!=null)+"");

    }

    public void moneyMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");

        String inId=req.getParameter("inId");
        String inName=req.getParameter("inName");

        Account account = accountService.accountInInfoService(inId,inName);

        resp.getWriter().write((account!=null)+"");
    }

    public void transferMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");

        String outId = req.getParameter("outId");
        String inId = req.getParameter("inId");
        Double money = Double.valueOf(req.getParameter("money"));

        int i = accountService.transferService(outId,inId,money);

        resp.getWriter().write((i==2)+"");

    }


}
