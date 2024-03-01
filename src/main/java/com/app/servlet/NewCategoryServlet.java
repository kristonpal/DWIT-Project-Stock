package com.app.servlet;

import com.app.services.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by krist on 05/09/2018.
 */
@WebServlet(name = "NewCategoryServlet")
public class NewCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService();

        request.setAttribute("categoryList", categoryService.getCategoryList());
        request.getRequestDispatcher("/jsp/category.jsp").forward(request, response);


    }
}
