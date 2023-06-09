package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.dataLayer.ISolutions;
import com.example.AutoGrad.dataLayer.dao.SolutionDAO;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class SolutionController {
    AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    ISolutions solutionService = new Solutions(factory.getSolutionFactory().create());
    private SolutionDAO solutionDAO = new SolutionDAO();
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
