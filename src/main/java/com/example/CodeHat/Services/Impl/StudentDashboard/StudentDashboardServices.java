package com.example.CodeHat.Services.Impl.StudentDashboard;

import com.example.CodeHat.Model.StudentProfile;
import com.example.CodeHat.Services.IStudentDashboardService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDashboardServices implements IStudentDashboardService {
    @Lazy
    private Connection connection = com.example.CodeHat.Services.Connection.getInstance();

    @Override
    public ResponseEntity getStudentById(Integer userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getStudentProfile(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            StudentProfile studentProfileData = new StudentProfile();
            if (resultSet.next()) {
                studentProfileData.setFirstName(resultSet.getString("user_first_name"));
                studentProfileData.setLastName(resultSet.getString("user_last_name"));
                studentProfileData.setEmail(resultSet.getString("user_email"));
                studentProfileData.setScore(resultSet.getInt("score"));
                studentProfileData.setNumberOfProblemSolved(resultSet.getInt("numberOfProblemSolved"));
                return ResponseEntity.ok().body(studentProfileData);
            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
