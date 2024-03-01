package com.app.servlet.supervisor;

import com.app.domain.Supervisor;
import com.app.services.SupervisorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by krist on 07/09/2018.
 */
@WebServlet(name = "SupervisorServlet")
public class SupervisorServlet extends HttpServlet {
    SupervisorService supervisorService = new SupervisorService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("sname");


        Supervisor supervisor = new Supervisor();
        supervisor.setName(name);

        if(action.equals("add")){
            supervisorService.addSupervisor(supervisor);
        }
        else if(action.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            supervisorService.updateSupervisor(supervisor);
        }

        request.setAttribute("supervisorList", supervisorService.getSupervisorList());
        request.getRequestDispatcher("/jsp/supervisor/supervisor.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action = " + action);
        int id = Integer.parseInt(request.getParameter("id"));

        if(action.equals("delete")){
            supervisorService.deleteSupervisor(id);
            request.setAttribute("supervisorList", supervisorService.getSupervisorList());
            request.getRequestDispatcher("/jsp/supervisor/supervisor.jsp").forward(request, response);
        }
        else if(action.equals("edit")){
            Supervisor supervisor = supervisorService.getSupervisor(id);

            request.setAttribute("supervisor", supervisor);

            request.getRequestDispatcher("/jsp/supervisor/editsupervisor.jsp").forward(request, response);
        }
    }
}
