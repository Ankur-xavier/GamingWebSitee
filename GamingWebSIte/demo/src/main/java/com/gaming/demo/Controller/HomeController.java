package com.gaming.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaming.demo.dao.UserRepository;
import com.gaming.demo.entities.User;

import jakarta.validation.Valid;

@Controller
class HomeController
{  
    @Autowired
	private UserRepository userRepository;


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
    
    @RequestMapping("/signup")
    public String signup(Model model)
    { model.addAttribute("user", new User());
     return "signup";
    }

    @PostMapping("/process_form")
    public String processSignup(@Valid @ModelAttribute("user") User user ,BindingResult bResult,Model model)
    {    
       
        if(bResult.hasErrors())
        {
            System.out.println("ERROR"+bResult.toString());
				model.addAttribute("user",user);
				return "signup";
        }
                
        System.out.println("User is "+ user.toString());
        this.userRepository.save(user);
        model.addAttribute("signupStatus", "Signup successful!");
        return "signup";
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