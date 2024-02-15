package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.Course;
import org.example.models.student;
import org.example.utils.studentDAO;

import java.io.IOException;
import java.util.List;
@WebServlet("/autoCorrect")

public class autoCorrectStudent extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Fname = request.getParameter("Fname");
        String Lname = request.getParameter("Lname");
        studentDAO studentDAO = new studentDAO();
        List<student> autoId = studentDAO.autoStudent(Fname, Lname);
        request.setAttribute("autoId", autoId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }
}
