package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillType;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.AdminHomeModel;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping("/admin-fe")
public class AdminHomeController {

    @Autowired
    private AdminHomeModel ahm;

    @GetMapping("/skill-management")
    public ModelAndView directToSkillManagementPage(ModelAndView mv){
        mv.setViewName("admin/skill");
        mv.addObject("skillTypes", Arrays.stream(SkillType.values()).toList());
        mv.addObject("skills", ahm.getAllSkills());
        return mv;
    }

    @GetMapping("/candidate-management")
    public ModelAndView directToCandidateMangementPage(ModelAndView mv){
        mv.setViewName("admin/candidate");
        mv.addObject("candidates", ahm.getAllCandidates());
        return mv;
    }

    @GetMapping("/address-management")
    public ModelAndView directToAddressManagementPage(ModelAndView mv){
        mv.setViewName("admin/address");
        mv.addObject("addresses", ahm.getAllAddresses());
        return mv;
    }

    @GetMapping("/company-management")
    public ModelAndView directToCompanyManagementPage(ModelAndView mv){
        mv.setViewName("admin/company");
        mv.addObject("addresses", ahm.getAllAddresses());
        mv.addObject("companies", ahm.getAllCompanies());
        return mv;
    }

}
