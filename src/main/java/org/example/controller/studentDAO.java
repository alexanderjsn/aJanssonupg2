package org.example.controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.models.student;

import org.example.utils.DBconnector;


public class studentDAO {

    // sql kommands


    // hämta data
    private static final String GET_STUDENTS = "SELECT * FROM students;";

    // skicka data

    // ta bort data



    //tar in java beans student klass
    public List<student> getStudents() throws SQLException {

        // lista för student data som kan sättas in överallt i kod
        List<student> students = new ArrayList<>();
        // hämtar connection instans för att ansluta
        try (Connection connection = DBconnector.getConnection();
             // inj säkert statement
        PreparedStatement pstmt = connection.prepareStatement(GET_STUDENTS);
            // hämtar resultat av query
        ResultSet rs = pstmt.executeQuery()){

            // hämtar data
            while(rs.next()){
                int id = rs.getInt("student_id");
                String fname = rs.getString("Fname");
                String lname = rs.getString("Lname");
                String city = rs.getString("city");
                String hobby = rs.getString("hobby");
                students.add(new student(id,fname,lname,city,hobby));
            }
        }
        return students;
    }
}


