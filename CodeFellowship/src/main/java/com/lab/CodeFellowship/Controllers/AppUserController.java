package com.lab.CodeFellowship.Controllers;

import com.lab.CodeFellowship.Models.AppUser;
import com.lab.CodeFellowship.Models.Post;
import com.lab.CodeFellowship.Repositries.AppUserRepository;
import com.lab.CodeFellowship.Repositries.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.xml.transform.sax.SAXResult;
import java.util.Date;
import java.util.List;

@Controller
public class AppUserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AppUserRepository appUserRepository;

    PostRepository postRepository;

    public AppUserController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/")
    public String getHomePage(@RequestParam String username,Model model){
        model.addAttribute("userList", appUserRepository.findByUsername(username));
        model.addAttribute("PostList",postRepository.findAll());

        return "home";
    }

    @PostMapping("/")
    public String homePage(@RequestParam String username,Model model){
        model.addAttribute("userList", appUserRepository.findByUsername(username));
        model.addAttribute("PostList",postRepository.findAll());

        return "home";
    }

    @GetMapping("/logout")
    public String logoutPage(){
        return "/logout";
    }

    @PostMapping("/post")
    public RedirectView makePost(@RequestParam String username, @RequestParam String body){
        Post post= new Post(body);
       AppUser appUser = appUserRepository.findByUsername(username);
       post.setAppUser(appUser);
       postRepository.save(post);
        return new RedirectView("/?username="+username);
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPage(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String dateOfBirth,
            @RequestParam String bio){
        AppUser appUser = new AppUser( passwordEncoder.encode(password),username,firstname,lastname,dateOfBirth,bio);
        appUserRepository.save(appUser);
        return "login";
    }
}
