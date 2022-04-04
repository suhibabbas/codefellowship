package com.lab.CodeFellowship.Controllers;

import com.lab.CodeFellowship.Repositries.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoderController {

    @Autowired
    CoderRepository coderRepository;

    @GetMapping("/profile")
    public String getProfile(Model model , @RequestParam Long id){
        model.addAttribute("profile", coderRepository.findById(id));
        return "home";
    }

}
