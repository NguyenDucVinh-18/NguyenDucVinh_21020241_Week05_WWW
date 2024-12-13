package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home-fe")
public class HomeController {

    @GetMapping("/admin")
    public String directToAdminArea(){
        return "admin/admin-home";
    }

    @GetMapping("/login")
    public String directToLogin(){
        return "login";
    }

    @GetMapping("/logout")
    public String directToLogout(HttpServletRequest request){
        request.getServletContext().setAttribute("account_login", null);
        return "redirect:/";
    }

    @GetMapping("/create-account")
    public String directToCreateAccount(){
        return "createAccount";
    }
}
