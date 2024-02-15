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

@WebServlet("/student")

public class viewstudentServlet extends HttpServlet {

    // hämtar studentDAO så jag kan hämta listan med studenter
    private final org.example.utils.studentDAO studentDAO = new studentDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // skapar en lista som fylld med data från studentDAO listan
        List<student> students = studentDAO.getStudents();


        // request har value av  listan ( skicka denna till - > )
        request.setAttribute("students",students);
        // - > JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchFname = request.getParameter("searchFName");
        String searchLname = request.getParameter("searchLName");
        studentDAO studentDAO = new studentDAO();
        List<student> searchedStudents = studentDAO.searchStudent(searchFname, searchLname);

        request.setAttribute("searchedStudents",searchedStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("foundStudents.jsp");
        dispatcher.forward(request, response);
    }
}
