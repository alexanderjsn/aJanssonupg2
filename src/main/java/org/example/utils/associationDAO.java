package org.example.utils;
import org.example.models.association;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class associationDAO {

    private static final String GET_ADMIN = "SELECT * FROM association;";

        public List<association> getAssociations() {
            List<association> associations = new ArrayList<>();
            try (Connection connection = DBconnector.getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(GET_ADMIN);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("student_id");
                    int courseId = rs.getInt("course_id");
                    associations.add(new association(id, studentId, courseId));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return associations;
        }
    }


