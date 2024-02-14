package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.Course;
import org.example.models.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/course")
public class viewCourseServlet extends HttpServlet {


    // hämtar studentDAO så jag kan hämta listan med studenter
    private final courseDAO courseDAO = new courseDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // skapar en lista som fylld med data från studentDAO listan
        List<Course> courseList = courseDAO.getCourse();


        // request har value av  listan ( skicka denna till - > )
        request.setAttribute("courseList",courseList);
        // - > JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("course.jsp");
        dispatcher.forward(request,response);
    }
}


