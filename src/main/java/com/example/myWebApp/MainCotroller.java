package com.example.myWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCotroller {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }
}
