package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.student;
import org.example.utils.courseDAO;

import java.io.IOException;
import java.util.List;
@WebServlet("/addCourse")

public class addcourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int yhp = Integer.parseInt(request.getParameter("yhp"));
        String description = request.getParameter("description");

        courseDAO courseDAO = new courseDAO();
        courseDAO.addCourse(name,yhp,description);
        response.sendRedirect("course");

    }
}

