package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillType;

import java.util.Arrays;

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

    @GetMapping("/create-account-candidate")
    public String directToCreateAccount(){
        return "createAccountCandidate";
    }

    @GetMapping("/create-account-company")
    public String directToCreateAccountCompany(){
        return "createAccountCompany";
    }

    @GetMapping("/home-company")
    public String directToHomeCandidate(){
        return "homeCompany";
    }

    @GetMapping("/add-job/company={companyId}")
    public ModelAndView directToAddJob(@PathVariable("companyId") Long companyId, ModelAndView mv){
        mv.addObject("skillTypes", Arrays.stream(SkillType.values()).toList());
        mv.addObject("skillLevels", Arrays.stream(SkillLevel.values()).toList());
        mv.addObject("companyId", companyId);
        mv.setViewName("AddJob");
        return mv;
    }
}
