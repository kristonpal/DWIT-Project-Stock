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


@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String username = request.getParameter("username");
        String password = LoginService.getPasswordHashed(request.getParameter("password"));
        String role = request.getParameter("role");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        if(action.equals("add")){
            userService.addUser(user);
        }
        else if(action.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            userService.updateUser(user);
        }

        request.setAttribute("userList", userService.getUserList());
        request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if(action.equals("delete")){
            userService.deleteUser(id);
            request.setAttribute("userList", userService.getUserList());
            request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
        }
        else if(action.equals("edit")){
            User user = userService.getUser(id);

            request.setAttribute("user", user);
            request.getRequestDispatcher("/jsp/edit.jsp").forward(request, response);
        }
    }
}
