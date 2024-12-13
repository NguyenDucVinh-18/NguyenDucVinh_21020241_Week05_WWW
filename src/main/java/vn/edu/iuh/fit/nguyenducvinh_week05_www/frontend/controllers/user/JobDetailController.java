package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;

@Controller
@RequestMapping("/user-fe/skill")
public class JobDetailController {
    @GetMapping("/jobs/{jobId}/skills/{skillId}/detail")
    public ModelAndView getJobDetail(@PathVariable("jobId") Long jobId,@PathVariable("skillId") Long skillId, ModelAndView mv) {
        // Lấy thông tin chi tiết công việc từ service hoặc model dựa trên jobId
//        Job job = jobService.getJobById(jobId);

//        mv.addObject("job", job); // Thêm đối tượng Job vào ModelAndView
        mv.setViewName("job-detail"); // Đặt tên view
        return mv;
    }
}
