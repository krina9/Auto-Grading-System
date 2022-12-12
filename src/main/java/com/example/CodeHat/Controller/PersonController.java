package com.example.CodeHat.Controller;

import com.example.CodeHat.Model.Person;
import com.example.CodeHat.Services.dbConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    dbConnection conn = new dbConnection();
    List<Person> data = conn.makeConnection();

    @GetMapping
    String getPeople(Model model){

        System.out.println(data);
        model.addAttribute("autograde", "AutoGrade > Leader Board");
        model.addAttribute("people", data);

        return "people";
    }
}
