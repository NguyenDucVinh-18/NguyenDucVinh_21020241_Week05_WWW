package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateSkillModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.JobSkillModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user-fe/skill")
public class SkillUserController {

    @Autowired
    CandidateSkillModel ckm;

    @Autowired
    private JobSkillModel jsm;
    @GetMapping("/jobs/{id}")
    public ModelAndView getAllJobsBySkill(@PathVariable("id") String skillId, ModelAndView mv, HttpServletRequest request) {
        List<JobSkill> jobSkills = jsm.getAllJobsBySkill(Long.parseLong(skillId));
//        CandidateRole role = CandidateRole.valueOf(request.getServletContext().getAttribute("role").toString());
        Candidate candidate = (Candidate) request.getServletContext().getAttribute("account_login");
        mv.addObject("candidate", candidate);
        List<Skill> skills = (List<Skill>) request.getServletContext().getAttribute("skills");
//        mv.addObject("role", role);
        List<CandidateSkill> candidateSkillList = ckm.getAllSkillByCan(candidate.getId());
        mv.addObject("candidateSkillList", candidateSkillList);
        List<JobSkill> jks = new ArrayList<>();
        for (CandidateSkill candidateSkill : candidateSkillList) {
//            List<JobSkill> jobSkillList = jsm.getAllJobsBySkill(Long.parseLong(String.valueOf(candidateSkill.getId().getSkill().getId())));
            jks.addAll(jsm.getAllJobsBySkill(Long.parseLong(String.valueOf(candidateSkill.getId().getSkill().getId()))));

        }
        System.out.println("jobSkills: " + jks);

        mv.addObject("jobSuggestions", jks);
        mv.addObject("account_login", candidate);
        mv.addObject("skills", skills);
        mv.addObject("jobSkills", jobSkills);
        mv.setViewName("homeCandidate");
        return mv;
    }
//
}
