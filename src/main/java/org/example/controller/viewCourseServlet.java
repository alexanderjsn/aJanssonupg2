package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.Course;
import org.example.utils.courseDAO;
import org.example.utils.studentDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/course")
public class viewCourseServlet extends HttpServlet {


    // hämtar studentDAO så jag kan hämta listan med studenter
    private final org.example.utils.courseDAO courseDAO = new courseDAO();

    studentDAO s = new studentDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // skapar en lista som fylld med data från studentDAO listan
        List<Course> courseList = courseDAO.getCourse();

        // request har value av  listan ( skicka denna till - > )
        request.setAttribute("courseList", courseList);
        // - > JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("course.jsp");
        dispatcher.forward(request, response);
    }

}


