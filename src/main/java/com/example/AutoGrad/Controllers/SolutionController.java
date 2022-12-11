package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.Services.ISolutionService;
import com.example.AutoGrad.Services.IUserService;
import com.example.AutoGrad.Services.Impl.SolutionService;
import com.example.AutoGrad.Services.Impl.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SolutionController {

    @Lazy
    private ISolutionService solutionService = new SolutionService();

    @PostMapping("/api/user/{userId}/problem/{problemId}/solve")
    public ResponseEntity solve(@RequestBody MultipartFile solution, @PathVariable int userId, @PathVariable int problemId) throws Exception {
        Solutions userSolution = solutionService.addSolution(userId, problemId, solution);
        if(userSolution == null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(userSolution);
    }

    @GetMapping("/api/user/{userId}/problem/{problemId}/solutions")
    public ResponseEntity getAllUserSolutions(@PathVariable int userId, @PathVariable int problemId) {
        List<Solutions> solutions = solutionService.getSolutionsByUserIdAndProblemId(userId, problemId);
        if(solutions == null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(solutions);
    }
}
