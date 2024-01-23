package com.gaming.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class HomeController
{
    @GetMapping("/")
    public String home(Model model)
    {  
        model.addAttribute("tittle", "Home Page");
       
        return  "home";
    }

    @GetMapping("/about")
    public String about(Model model)
    {  
        model.addAttribute("tittle", "About Page");
       
        return  "about";
    }
    
    @GetMapping("/signup")
    public String signup(Model model)
    {
     return "signup";
    }

    @PostMapping("/process_form")
    public String processSignup()
    {

   return "/process";
    }

    @GetMapping("/login")
    public String loginUser()
    {

        return "login";
    }

    @PostMapping("/post_login")
    public String postLogin()
    {

        return "/process";
    }

}