package org.example.utils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.models.Course;

import org.example.models.student;


public class courseDAO {

    // sql kommands

    private static final String ADD_BOTH = "INSERT INTO association (student_id, course_id) VALUES (?, ?);";


    // hämta data
    private static final String GET_COURSES = "SELECT * FROM courses;";

    // skicka data
    private static final String ADD_COURSES = "INSERT INTO courses (name, YHP, description) VALUES (?, ?, ?);";

    // ta bort data



    public void addBoth(int student_id, int course_id) {
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(ADD_BOTH)) {
            pstmt.setInt(1, student_id);
            pstmt.setInt(2, course_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
                int yhp = rs.getInt("YHP");
                String description = rs.getString("description");
                courses.add(new Course(courseId,name,yhp,description));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public void addCourse(String name, int yhp, String description) {
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(ADD_COURSES)) {
            pstmt.setString(1, "%" + name + "%");
            pstmt.setString(2, String.valueOf(yhp));
            pstmt.setString(3, "%" + description + "%");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
