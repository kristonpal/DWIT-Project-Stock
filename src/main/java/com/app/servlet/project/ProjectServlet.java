package com.app.servlet.project;

import com.app.domain.Project;
import com.app.services.ProjectService;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "index.jsp")
public class ProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Project> projects =  new ProjectService().getProjectList();

        String action = request.getParameter("action");

        projects.forEach(x -> System.out.println(x.getName()));


        System.out.println("Called all project  " + action);

        if (projects != null)
            request.setAttribute("projects", projects);
        else
            request.setAttribute("projects", null);

        request.getRequestDispatcher("/jsp/project/showProjects.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get called");
        doPost(request, response);
    }
}
