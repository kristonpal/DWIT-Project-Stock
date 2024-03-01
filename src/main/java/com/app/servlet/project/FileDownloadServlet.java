package com.app.servlet.project;

import com.app.domain.Project;
import com.app.services.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(name = "FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //if we get download request we get the id parameter , query to db about that id , get Blob , convert to Inputstream and write file
        String id = request.getParameter("id");
        Project project= null; // get user info with blob fromdb
        try {
            project = new ProjectService().getProjectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String filename = project.getFilename();
        System.out.println("filename = " + filename);
/*        InputStream fileFromDb = null; //set inputstream to convert blob to inputstream
        PrintWriter out = response.getWriter(); //printwriter object
        try {
            fileFromDb = project.getFile().getBinaryStream(); //get blob and convert to binary stream(inputstream)
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("APPLICATION/OCTET-STREAM"); //set contenttype/header for download
        response.setHeader("Content-Disposition", "attachment:filename=\""+filename+"\"");
        int i=0;
        while ((i=fileFromDb.read()) != -1)
            out.write(i); //looop thorough and write
        out.close();
        fileFromDb.close();*/

        String contentType = this.getServletContext().getMimeType(filename);
        response.setHeader("Content-Type", contentType);
        try {
            response.setHeader("Content-Length", String.valueOf(project.getFile().length()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setHeader("Content-Disposition", "inline; filename=\""+filename+"\"");

        Blob fileData = project.getFile();

        InputStream is = null;
        try {
             is = fileData.getBinaryStream();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        byte[] bytes = new byte[1024];
        int bytesRead;
        while((bytesRead = is.read(bytes)) != -1){
            response.getOutputStream().write(bytes,0, bytesRead);
        }

        is.close();



    }
}
