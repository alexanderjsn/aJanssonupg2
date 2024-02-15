package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.student;
import org.example.utils.studentDAO;

import java.io.IOException;
import java.util.List;
@WebServlet("/addStudent")

public class addstudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Fname = request.getParameter("Fname");
        String Lname = request.getParameter("Lname");
        String hobby = request.getParameter("city");
        String city = request.getParameter("hobby");
        studentDAO studentDAO = new studentDAO();
        studentDAO.addStudent(Fname, Lname, city, hobby);

        response.sendRedirect("student");

    }
}

