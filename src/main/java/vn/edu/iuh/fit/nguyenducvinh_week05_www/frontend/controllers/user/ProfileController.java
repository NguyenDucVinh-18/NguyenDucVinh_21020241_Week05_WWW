package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateModel;

@Controller
@RequestMapping("/user-fe/profile")
public class ProfileController {

    @Autowired
    private CandidateModel cm;

    @GetMapping("/candidateId={candidateId}")
    public ModelAndView getJobDetail(@PathVariable("candidateId") Long candidateId, ModelAndView mv) {
        Candidate candidate = cm.getCandidateById(candidateId);
        mv.addObject("candidate", candidate);
        mv.setViewName("ProfileUser");
        return mv;
    }

}
