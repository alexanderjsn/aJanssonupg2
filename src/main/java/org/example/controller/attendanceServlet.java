package org.example.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.Course;
import org.example.models.student;
import org.example.models.association;
import org.example.utils.courseDAO;
import org.example.utils.studentDAO;
import org.example.utils.associationDAO;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet("/attendance")
public class attendanceServlet extends HttpServlet {

    private final org.example.utils.associationDAO associationDAO = new associationDAO();
    private final org.example.utils.studentDAO studentDAO = new studentDAO();
    private final org.example.utils.courseDAO courseDAO = new courseDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<association> associationList = associationDAO.getAssociations();
        List<student> students = studentDAO.getStudents();
        List<Course> courseList = courseDAO.getCourse();

        request.setAttribute("associationList", associationList);
        request.setAttribute("courseList", courseList);
        request.setAttribute("students",students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int student_id = Integer.parseInt(request.getParameter("student_id"));
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        try {
            courseDAO.addBoth(student_id, course_id);
            response.sendRedirect("attendance");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("attendance");
        }
    }


}


