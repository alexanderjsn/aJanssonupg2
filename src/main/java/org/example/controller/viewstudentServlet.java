package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/students")

public class viewstudentServlet extends HttpServlet {

    // hämtar studentDAO så jag kan hämta listan med studenter
    private final studentDAO studentDAO = new studentDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // skapar en lista som fylld med data från studentDAO listan
        List<student> students = null;
        try {
            students = studentDAO.getStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // request har value av  listan ( skicka denna till - > )
        request.setAttribute("students",students);
        // - > JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request,response);
    }
}
