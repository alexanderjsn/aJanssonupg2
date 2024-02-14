package org.example.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.models.Course;

import org.example.utils.DBconnector;


public class courseDAO {

    // sql kommands


    // hämta data
    private static final String GET_COURSES = "SELECT * FROM courses;";

    // skicka data

    // ta bort data



    //tar in java beans student klass
    public List<Course> getCourse() {

        // lista för student data som kan sättas in överallt i kod
        List<Course> courses = new ArrayList<>();
        // hämtar connection instans för att ansluta
        try (Connection connection = DBconnector.getConnection();
             // inj säkert statement
             PreparedStatement pstmt = connection.prepareStatement(GET_COURSES);
             // hämtar resultat av query
             ResultSet rs = pstmt.executeQuery()){

            // hämtar data
            while(rs.next()){
                int courseId = rs.getInt("course_id");
                String name = rs.getString("name");
                int YHP = rs.getInt("YHP");
                String description = rs.getString("description");
                courses.add(new Course(courseId,name,YHP,description));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
