package com.app.servlet.supervisor;

import com.app.services.SupervisorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by krist on 07/09/2018.
 */
@WebServlet(name = "NewSupervisorServlet")
public class NewSupervisorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupervisorService supervisorService = new SupervisorService();

        request.setAttribute("supervisorList", supervisorService.getSupervisorList());
        request.getRequestDispatcher("/jsp/supervisor/supervisor.jsp").forward(request, response);
    }
}
