package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
import com.example.AutoGrad.dataLayer.IUser;
import com.example.AutoGrad.dataLayer.dao.UserDAO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private UserDAO userDAO = new UserDAO();
    private IUser userServices = new User(userDAO);

    @GetMapping("/api/user/email/{user_email}")
    public ResponseEntity getUerByEmail(@PathVariable String user_email) {
        User user = userServices.getUserByEmail(user_email);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/api/user/update")
    public ResponseEntity update(@RequestBody UserDTO userDTO) {
        User user = userServices.updateUser(userDTO);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/api/user/change-password")
    public ResponseEntity updatePwd(@RequestBody ChangePasswordDTO data) {
        User user = userServices.updatePassword(data);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/api/user/{userId}/get-problem-solved")
    public ResponseEntity getNumberOfProblemSolvedByUserId(@PathVariable int userId) {
        int problemSolved = userServices.getNumberOfProblemSolvedByUser(userId);
        return ResponseEntity.ok().body(problemSolved);
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity getUserByUserId(@PathVariable int userId) {
        User user = userServices.getUserById(userId);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/user/{userId}/get-score")
    public ResponseEntity getScoreByUserId(@PathVariable int userId) {
        double score = userServices.getScoreByUserId(userId);
        return ResponseEntity.ok().body(score);
    }

}
