package org.example.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.Course;
import org.example.models.student;
import org.example.utils.courseDAO;
import org.example.utils.studentDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/attendance")
public class attendanceServlet extends HttpServlet {

    private final org.example.utils.studentDAO studentDAO = new studentDAO();
    private final org.example.utils.courseDAO courseDAO = new courseDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<student> students = studentDAO.getStudents();
        List<Course> courseList = courseDAO.getCourse();
        request.setAttribute("courseList", courseList);
        request.setAttribute("students",students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }


}


