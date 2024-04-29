package com.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.service.loginService;
@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class login extends HttpServlet {

    private loginService loginservice= new loginService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isLogin = loginservice.checkLogin(email, password);
        System.out.println(isLogin);

        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}
