package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.*;
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
    private CompanyModel companyModel;

    @Autowired
    private AddressModel addm;

    @Autowired
    private SkillModel skillModel;

    @Autowired
    private JobSkillModel jsm;

    @Autowired
    private CandidateSkillModel ckm;

    @Autowired
    private JobModel jobModel;

    @PostMapping("/loginCandidate")
    public ModelAndView checkLogin(
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPassword") String password,
            HttpServletRequest request
    ) {
        ModelAndView mv;
        Candidate target = am.checkLogin(email, password);
        if (target == null) {
            // Nếu đăng nhập thất bại
            mv = new ModelAndView("loginPage"); // Redirect back to the login page
            mv.addObject("errorMessage", "Invalid email or password. Please try again.");
        } else {
            // Nếu đăng nhập thành công
            request.getServletContext().setAttribute("account_login", target);
            Candidate candidate = am.checkLogin(email, password);
            request.getServletContext().setAttribute("skills", skillModel.getAllSkills());
            mv = new ModelAndView("homeCandidate");
            mv.addObject("candidate", candidate);
            List<CandidateSkill> candidateSkillList = ckm.getAllSkillByCan(candidate.getId());
            mv.addObject("candidateSkillList", candidateSkillList);
            List<JobSkill> jobSkills = new ArrayList<>();
            for (CandidateSkill candidateSkill : candidateSkillList) {
                jobSkills.addAll(jsm.getAllJobsBySkill(Long.parseLong(String.valueOf(candidateSkill.getId().getSkill().getId()))));
            }
            mv.addObject("jobSuggestions", jobSkills);
            mv.addObject("account_login", target);
            mv.addObject("skills", skillModel.getAllSkills());
        }
        return mv;
    }


    @PostMapping("/loginCompany")
    public ModelAndView checkLoginCompany(
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPassword") String password,
            HttpServletRequest request
    ) {
        ModelAndView mv = new ModelAndView("homeCompany");
        Company target = am.checkLoginCompany(email, password);
        request.getServletContext().setAttribute("account_login", target);

        Company company = am.checkLoginCompany(email, password);
        mv.addObject("company", company);
        List<Job> jobs = jobModel.findListJobByCompanyId(company.getId());
//        mv.addObject("jobs", jobs);
        List<JobSkill> jobSkills = new ArrayList<>();
        for (Job job : jobs) {
            jobSkills.addAll(jsm.getAllJobSkillByJob(job.getId()));
        }
        mv.addObject("jobSkills", jobSkills);
        mv.addObject("account_login", target);
        mv.addObject("skills", skillModel.getAllSkills());
        return mv;
    }


    @PostMapping("/create-account-candidate")
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
            mv.setViewName("index");
        } else {
            mv.addObject("status", "Register failed! Please contact to administrator");
            mv.setViewName("createAccountCandidate");
        }
        return mv;
    }

    @PostMapping("/create-account-company")
    public ModelAndView createAccountCompany(
            @RequestParam("compName") String companyName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("webUrl") String webUrl,
            @RequestParam("about") String about,
            @RequestParam("password") String password,
            @RequestParam("street") String street,
            @RequestParam("city") String city,
            @RequestParam("number") String number,
            @RequestParam("country") Short country,
            @RequestParam("zipcode") String zipcode,
            ModelAndView mv
    ){
        mv.setViewName("index");
        Address address = addm.addAddress(new Address(street, city, country, number, zipcode));
        Company company = new Company(about, email, password, companyName, phone, webUrl, address);
        companyModel.addCompany(company);
        return mv;
    }
}
