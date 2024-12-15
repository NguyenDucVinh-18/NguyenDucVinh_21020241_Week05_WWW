package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateSkillModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.SkillModel;

import java.util.List;

@Controller
@RequestMapping("/user-fe/profile")
public class ProfileController {

    @Autowired
    private CandidateModel cm;

    @Autowired
    private SkillModel sm;

    @Autowired
    private CandidateSkillModel ckm;

    @GetMapping("/candidateId={candidateId}")
    public ModelAndView getJobDetail(@PathVariable("candidateId") Long candidateId, ModelAndView mv) {
        Candidate candidate = cm.getCandidateById(candidateId);
        mv.addObject("candidate", candidate);
        mv.addObject("skills", sm.getAllSkills());
        List<CandidateSkill> candidateSkillList = ckm.getAllSkillByCan(candidate.getId());
        mv.addObject("candidateSkillList", candidateSkillList);
        mv.setViewName("ProfileUser");
        return mv;
    }

    @PutMapping("/updateCandidate={candidateId}")
    public ModelAndView updateCandidate(@PathVariable("candidateId") Long candidateId, ModelAndView mv) {
        Candidate candidate = cm.getCandidateById(candidateId);
        mv.addObject("candidate", candidate);
        mv.addObject("skills", sm.getAllSkills());
        mv.setViewName("ProfileUser");
        return mv;
    }

//    @PostMapping("/candidate/addSkill/${candidateId}?skillId=${skillId}")
//    public ResponseEntity<String> addSkillToCandidate(@PathVariable("candidateId") Long candidateId, @RequestParam("skillId") Long skillId) {
//        Candidate candidate = cm.getCandidateById(candidateId); // Lấy candidate từ database
//        Skill skill = sm.getSkillById(skillId); // Lấy kỹ năng từ database
//        System.out.println("SkillName: " + skill.getSkillName());
//
//        if (candidate != null && skill != null) {
////            candidate.getSkills().add(skill); // Thêm kỹ năng vào danh sách kỹ năng của candidate
//            CandidateSkillId candidateSkillId = new CandidateSkillId(candidate, skill);
//            CandidateSkill candidateSkill = new CandidateSkill(candidateSkillId,"MoreInfor", SkillLevel.BEGINER);
//            ckm.addCandidateSkill(candidateSkill); // Thêm candidateSkill vào database
////            cm.saveCandidate(candidate); // Cập nhật candidate vào database
//            return ResponseEntity.ok("Skill added successfully.");
//        }
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error adding skill.");
//    }


}
