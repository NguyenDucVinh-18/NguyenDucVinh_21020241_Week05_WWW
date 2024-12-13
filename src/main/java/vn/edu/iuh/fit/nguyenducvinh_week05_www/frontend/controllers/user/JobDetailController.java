package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.JobSkillModel;

import java.util.List;

@Controller
@RequestMapping("/user-fe/jobDetail")
public class JobDetailController {

    @Autowired
    private JobSkillModel skm;

    @GetMapping("/jobs={jobId}/skills={skillId}/detail")
    public ModelAndView getJobDetail(@PathVariable("jobId") Long jobId,@PathVariable("skillId") Long skillId, ModelAndView mv) {
        // Lấy thông tin chi tiết công việc từ service hoặc model dựa trên jobId
//        Job job = jobService.getJobById(jobId);
        JobSkill jobSkill = skm.getAllJobSkillsByJobIdAndSkillId(jobId,skillId);
        mv.addObject("jobSkill", jobSkill); // Thêm đối tượng Job vào ModelAndView
        mv.setViewName("JobDetail"); // Đặt tên view
        return mv;
    }
}
