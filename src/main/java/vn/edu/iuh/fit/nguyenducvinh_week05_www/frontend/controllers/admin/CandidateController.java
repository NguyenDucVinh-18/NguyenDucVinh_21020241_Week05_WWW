package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.AddressModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CandidateModel;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin-fe/candidate-management")
public class CandidateController {
    @Autowired
    private CandidateModel cm;

    @Autowired
    private AddressModel am;

    @PostMapping
    public ModelAndView addCandidate(
            @RequestParam("inputName") String name,
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPhone") String phone,
            @RequestParam("inputDob") LocalDate dob,
            @RequestParam("inputAddress") Long addressId,
            ModelAndView mv)
    {
//        mv.setViewName("redirect:/admin-fe/candidate-management");
//        Address address = am.getAddressById(addressId);
//        cm.addCandidate(dob, email, name, phone, password , address);
        return mv;
    }
}
