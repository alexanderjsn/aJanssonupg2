package org.example.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.models.course;

import org.example.utils.DBconnector;


public class courseDAO {

    // sql kommands


    // hämta data
    private static final String GET_STUDENTS = "SELECT * FROM students;";

    // skicka data

    // ta bort data



    //tar in java beans student klass
    public List<course> getCourse() throws SQLException {

        // lista för student data som kan sättas in överallt i kod
        List<course> courses = new ArrayList<>();
        // hämtar connection instans för att ansluta
        try (Connection connection = DBconnector.getConnection();
             // inj säkert statement
             PreparedStatement pstmt = connection.prepareStatement(GET_STUDENTS);
             // hämtar resultat av query
             ResultSet rs = pstmt.executeQuery()){

            // hämtar data
            while(rs.next()){
                int c_id = rs.getInt("course_id");
                String name = rs.getString("name");
                int YHP = rs.getInt("YHP");
                String description = rs.getString("description");
                courses.add(new course(c_id,name,YHP,description));
            }
        }
        return courses;
    }
}
