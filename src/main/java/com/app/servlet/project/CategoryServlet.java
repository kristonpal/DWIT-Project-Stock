package com.app.servlet.project;

import com.app.domain.Category;
import com.app.services.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by krist on 27/08/2018.
 */
@WebServlet(name="CategoryServlet")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        String name = request.getParameter("cname");


        Category category = new Category();
        category.setName(name);

        if(action.equals("add")){
            categoryService.addCategory(category);
        }
        else if(action.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            categoryService.updateCategory(category);
        }

        request.setAttribute("categoryList", categoryService.getCategoryList());
        request.getRequestDispatcher("/jsp/category.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        System.out.println("action = " + action);
        int id = Integer.parseInt(request.getParameter("id"));
        if(action.equals("delete")){
            categoryService.deleteCategory(id);
            request.setAttribute("categoryList", categoryService.getCategoryList());
            request.getRequestDispatcher("/jsp/category.jsp").forward(request, response);
        }
        else if(action.equals("edit")){
            Category category = categoryService.getCategory(id);

            request.setAttribute("category", category);

            request.getRequestDispatcher("/jsp/editcategory.jsp").forward(request, response);
        }
    }
}
