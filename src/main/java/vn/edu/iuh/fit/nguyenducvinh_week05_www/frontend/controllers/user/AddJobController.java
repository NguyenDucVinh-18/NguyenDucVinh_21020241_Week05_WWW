package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillType;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CompanyModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.JobModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.JobSkillModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.SkillModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user-fe/addJob")
public class AddJobController {

    @Autowired
    private CompanyModel cm;

    @Autowired
    private JobModel jm;

    @Autowired
    private SkillModel sm;

    @Autowired
    private JobSkillModel jsm;

    @PostMapping("/company={companyId}")
    public ModelAndView addJob(
            @PathVariable("companyId") Long companyId,
            @RequestParam("jobName") String jobName,
            @RequestParam("jobDesc") String jobDesc,
            @RequestParam("skillName") String skillName,
            @RequestParam("skillDesc") String skillDesc,
            @RequestParam("inputSkillType") String skillType,
            @RequestParam("inputSkillLevel") String skillLevel,
            ModelAndView mv,
            HttpServletRequest request
    ) {
        mv = new ModelAndView("homeCompany");
        Company company = cm.getCompanyById(companyId);
        mv.addObject("company", company);
        Job j = new Job(jobName, jobDesc, company);
        System.out.println(j.getJobName());


        Skill skill = new Skill(skillName, skillDesc, SkillType.valueOf(skillType));
        System.out.println(skill.getSkillName());


        JobSkillId jobSkillId = new JobSkillId(j, skill);
        System.out.println(jobSkillId.getJob().getJobName() + " " + jobSkillId.getSkill().getSkillName());
        JobSkill jobSkill = new JobSkill(jobSkillId, "more inform", SkillLevel.valueOf(skillLevel));

        jm.addJob(j);
        sm.addSkill(skill);
        System.out.println(j.getId());
        jsm.addJobSkill(jobSkill);


        mv.addObject("company", company);
        List<Job> jobs = jm.findListJobByCompanyId(company.getId());
        request.getServletContext().setAttribute("account_login", company);
//        mv.addObject("jobs", jobs);
        List<JobSkill> jobSkills = new ArrayList<>();
        for (Job job : jobs) {
            jobSkills.addAll(jsm.getAllJobSkillByJob(job.getId()));
        }
        mv.addObject("jobSkills", jobSkills);
        mv.addObject("account_login", company);
        mv.addObject("skills", sm.getAllSkills());

        return mv;
    }
}
