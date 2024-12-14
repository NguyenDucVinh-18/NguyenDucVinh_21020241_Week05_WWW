package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateSkillModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.JobSkillModel;

import java.util.List;

@Controller
@RequestMapping("/user-fe/candidateSuggestion")
public class CandidateSuggestForCompany {

    @Autowired
    private CandidateSkillModel ckm;

    @Autowired
    private JobSkillModel jsm;

    @GetMapping("/jobs={jobId}/skills={skillId}/suggest")
    public ModelAndView getJobDetail(@PathVariable("jobId") Long jobId,@PathVariable("skillId") Long skillId, ModelAndView mv) {
        List<CandidateSkill> candidateSkills = ckm.getAllCandidateSkillBySkill(skillId);
        JobSkill jobSkill = jsm.getAllJobSkillsByJobIdAndSkillId(jobId,skillId);
        mv.addObject("candidateSkills", candidateSkills); // Thêm đối tượng Job vào ModelAndView
        mv.addObject("jobSkill", jobSkill);
        mv.setViewName("SuggestCandidate"); // Đặt tên view
        return mv;
    }
}
