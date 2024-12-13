package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillType;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.SkillModel;

@Controller
@RequestMapping("/admin-fe/skill-management")
public class SkillController {

    @Autowired
    private SkillModel sm = new SkillModel();

    @PostMapping
    public ModelAndView addSkill(
            @RequestParam("inputSkillName") String skillName,
            @RequestParam("inpurSkillDescription") String skillDescription,
            @RequestParam("inputSkillType") String type,
            ModelAndView mv
    ){
        mv.setViewName("redirect:/admin-fe/skill-management");
        Skill skill = new Skill(skillDescription, skillName, SkillType.valueOf(type));
        sm.addSkill(skill);

        return mv;
    }
}
