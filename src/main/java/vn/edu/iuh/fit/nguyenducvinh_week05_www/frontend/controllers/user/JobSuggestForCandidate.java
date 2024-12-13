package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.CandidateRole;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateSkillModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.JobSkillModel;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/user-fe/jobSuggestion")
public class JobSuggestForCandidate {

    @Autowired
    private JobSkillModel jsm;

    @Autowired
    CandidateSkillModel ckm;

    @GetMapping("/skills/{id}")
    public ModelAndView getAllJobSuggestionForCandidate(@PathVariable("id") String canId, ModelAndView mv, HttpServletRequest request) {
        CandidateRole role = CandidateRole.valueOf(request.getServletContext().getAttribute("role").toString());
        Candidate candidate = (Candidate) request.getServletContext().getAttribute("account_login");
        mv.addObject("role", role);
        mv.addObject("account_login", candidate);
        List<CandidateSkill> candidateSkillList = ckm.getAllSkillByCan(Long.parseLong(canId));
        List<JobSkill> jobSkills = new ArrayList<>();
        for (CandidateSkill candidateSkill : candidateSkillList) {
            jobSkills.addAll(jsm.getAllJobsBySkill(Long.parseLong(String.valueOf(candidateSkill.getId().getSkill().getId()))));
        }

        mv.addObject("jobSuggestions", jobSkills);
        mv.setViewName("home");
        return mv;
    }


//
//
//    public ModelAndView getAllJobsBySkill(@PathVariable("id") String skillId, ModelAndView mv, HttpServletRequest request) {
//        List<JobSkill> jobSkills = jsm.getAllJobsBySkill(Long.parseLong(skillId));
//        CandidateRole role = CandidateRole.valueOf(request.getServletContext().getAttribute("role").toString());
//        Candidate candidate = (Candidate) request.getServletContext().getAttribute("account_login");
//        List<Skill> skills = (List<Skill>) request.getServletContext().getAttribute("skills");
//        mv.addObject("role", role);
//        mv.addObject("account_login", candidate);
//        mv.addObject("skills", skills);
//        mv.addObject("jobSkills", jobSkills);
//        mv.setViewName("home");
//        return mv;
//
//    }
}
