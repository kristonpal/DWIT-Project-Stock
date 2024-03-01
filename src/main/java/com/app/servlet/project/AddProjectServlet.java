package com.app.servlet.project;

import com.app.domain.Project;
import com.app.services.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProjectServlet")
@MultipartConfig
public class AddProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InputStream inputStream = null; // input stream of the upload file

        // gets values of text fil#
        int roll = Integer.parseInt(request.getParameter("proll"));
        String name = request.getParameter("pname");
        int year = Integer.parseInt(request.getParameter("pyear"));
        String semester = request.getParameter("psemester");
        String category = request.getParameter("pcategory");
        String title = request.getParameter("ptitle");
        String tags = request.getParameter("ptags");
        String supervisor = request.getParameter("psupervisor");
        String domain = request.getParameter("pdomain");
        String abstraction = request.getParameter("pabstraction");

        Part filePart = request.getPart("image");
        String filename = getFileName(filePart);


        if (filePart != null) {
//             prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

//             obtains input stream of the upload file
            inputStream = filePart.getInputStream();

        }

        System.out.println("roll          =" +roll);
        System.out.println("name         = " + name);
        System.out.println("year         = " + year);
        System.out.println("semester         = " + semester);
        System.out.println("category     = " + category);
        System.out.println("fileName         = " + filename);
        System.out.println("title        = " + title);
        System.out.println("tags         = " + tags);
        System.out.println("supervisor         = " + supervisor);
        System.out.println("domain     = " + domain);
        System.out.println("abstraction  = " + abstraction);

        Project project = new Project();
        project.setRoll(roll);
        project.setName(name);
        project.setYear(year);
        project.setSemester(semester);
        project.setCategory(category);
        project.setFilename(filename);
        project.setTitle(title);
        project.setTags(tags);
        project.setSupervisor(supervisor);
        project.setDomain(domain);
        project.setAbstraction(abstraction);


        boolean addToDB = new ProjectService().insertProjectWithFile(project, inputStream);


        System.out.println("========================= " + addToDB);

        if (addToDB) {

            request.setAttribute("msg", "Uploaded to Database in inputstream form");
            request.setAttribute("projectList", new ProjectService().getProjectList());
            request.getRequestDispatcher("/projects").forward(request, response);


        }else
            request.getRequestDispatcher("/projects").forward(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Gets the filename from uploaded part file
     *
     * @param part
     * @return
     */
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }
}
