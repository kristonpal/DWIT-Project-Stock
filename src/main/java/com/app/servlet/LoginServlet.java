package com.app.servlet;

import com.app.services.LoginService;
import com.app.domain.User;
import com.app.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = LoginService.getPasswordHashed(request.getParameter("password"));

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        LoginService loginService = new LoginService();
        UserService userService = new UserService();

        if(loginService.authenticate(user)){
            HttpSession session = request.getSession();
            session.setAttribute("username", username.toUpperCase());
            request.setAttribute("userList", userService.getUserList());
            request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
        }else{

            System.out.println("Wrong username and password");
            request.setAttribute("message","Either Username or Password is incorrect");
            request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/jsp/index.jsp");
    }
}
