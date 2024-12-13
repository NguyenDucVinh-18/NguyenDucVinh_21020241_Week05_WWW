package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Address;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/auth-fe")
public class AuthenticateController {


    @Autowired
    private AuthenticateModel am;

    @Autowired
    private CandidateModel cm;

    @Autowired
    private AddressModel addm;

    @Autowired
    private SkillModel skillModel;

    @Autowired
    private JobSkillModel jsm;

    @Autowired
    CandidateSkillModel ckm;

    @PostMapping("/login")
    public ModelAndView checkLogin(
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPassword") String password,
            HttpServletRequest request
    ) {
        ModelAndView mv = new ModelAndView("home");
        Candidate target = am.checkLogin(email, password);
        request.getServletContext().setAttribute("account_login", target);
//        request.getServletContext().setAttribute("role", target.getRole().toString());
        Candidate candidate = am.checkLogin(email, password);
        request.getServletContext().setAttribute("skills", skillModel.getAllSkills());
//        mv.addObject("role", target.getRole().toString());
        mv.addObject("candidate", candidate);
//        mv.addObject("jobSuggest",)
        List<CandidateSkill> candidateSkillList = ckm.getAllSkillByCan(candidate.getId());
        mv.addObject("candidateSkillList", candidateSkillList);
        List<JobSkill> jobSkills = new ArrayList<>();
        for (CandidateSkill candidateSkill : candidateSkillList) {
//            List<JobSkill> jobSkillList = jsm.getAllJobsBySkill(Long.parseLong(String.valueOf(candidateSkill.getId().getSkill().getId())));
            jobSkills.addAll(jsm.getAllJobsBySkill(Long.parseLong(String.valueOf(candidateSkill.getId().getSkill().getId()))));

        }

        mv.addObject("jobSuggestions", jobSkills);
        mv.addObject("account_login", target);
        mv.addObject("skills", skillModel.getAllSkills());
        return mv;
    }


    @PostMapping("/create-account")
    public ModelAndView createAccount(
            @RequestParam("inputFullName") String fullName,
            @RequestParam("inputPhone") String phone,
            @RequestParam("inputEmail") String email,
            @RequestParam("inputDob") String dob,
            @RequestParam("inputPassword") String password,
            @RequestParam("inputStreet") String street,
            @RequestParam("inputCity") String city,
            @RequestParam("inputCountry") String country,
            @RequestParam("inputNumber") String number,
            @RequestParam("inputZipcode") String zipCode,
            ModelAndView mv
    ) {
        String[] splitDate = dob.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));

        Address add = new Address(street, city, Short.parseShort(country), number, zipCode);

        Candidate candidate = new Candidate(
                date,
                email,
                fullName,
                phone,
                password,
                add
        );
        Address addResult = addm.addAddress(add);
        candidate.setAddress(addResult);

        boolean result = am.createAccount(candidate);
        if(result) {
            mv.addObject("status", "Register success! Please login to continue");
            mv.setViewName("home");
        } else {
            mv.addObject("status", "Register failed! Please contact to administrator");
            mv.setViewName("createAccount");
        }
        return mv;
    }
}
