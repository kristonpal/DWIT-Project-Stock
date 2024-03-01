package com.app.servlet;

import com.app.services.LoginService;
import com.app.domain.User;
import com.app.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // check if default user exist in db
        UserService userService = new UserService();
        if(!userService.checkUser()){

            // create default user in mysql db
            User user = new User();
            user.setFirstName("Kriston");
            user.setLastName("Pal");
            user.setUsername("kri");
            user.setRole("admin");
            user.setPassword(LoginService.getPasswordHashed("admin"));

            userService.addUser(user);
        }

        response.sendRedirect("/jsp/index.jsp");
    }
}
