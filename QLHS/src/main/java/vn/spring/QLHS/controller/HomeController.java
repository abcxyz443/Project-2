package vn.spring.QLHS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login/login";
    }
    @GetMapping()
    public String showHomePage(Model model){
        return "public/home";
    }
}
