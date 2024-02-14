package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.course;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/courses")
public class viewCourseServlet extends HttpServlet {


    // hämtar studentDAO så jag kan hämta listan med studenter
    private final courseDAO courseDAO = new courseDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<course> courses = null;
        try {
            courses = courseDAO.getCourse();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("courses",courses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("courses.jsp");
        dispatcher.forward(request,response);
    }
}


