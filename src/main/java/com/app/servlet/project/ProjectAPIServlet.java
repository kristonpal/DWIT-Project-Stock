package com.app.servlet.project;

import com.app.domain.Project;
import com.app.services.ProjectService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProjectAPIServlet", urlPatterns = "/api/projects")
public class ProjectAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("project project");

        String id = request.getParameter("id");

        Project project = new ProjectService().getProjectById(id);

        Map<String, String> abstraction  = new HashMap<String, String>();
        abstraction.put("abstraction", project.getAbstraction());

        Gson gson = new Gson();
        String serialized = gson.toJson(abstraction);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(serialized);



    }
}
