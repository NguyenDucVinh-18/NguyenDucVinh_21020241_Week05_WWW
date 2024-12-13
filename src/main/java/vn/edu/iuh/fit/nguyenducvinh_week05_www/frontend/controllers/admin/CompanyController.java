package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Address;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Company;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.AddressModel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.CompanyModel;

@Controller
@RequestMapping("/admin-fe/company-management")
public class CompanyController {
    @Autowired
    private CompanyModel cm;

    @Autowired
    private AddressModel am;


    @PostMapping
    public ModelAndView addCompany(
            @RequestParam("inputCompName") String companyName,
            @RequestParam("inputEmail") String email,
            @RequestParam("inputPhone") String phone,
            @RequestParam("inputWebUrl") String webUrl,
            @RequestParam("inputAbout") String about,
            @RequestParam("inputAddress") Long addressId,
            ModelAndView mv
    ){
        mv.setViewName("redirect:/admin-fe/company-management");
        Address address = am.getAddressById(addressId);
        Company company = new Company(about, email, companyName, phone, webUrl, address);
        cm.addCompany(company);
        return mv;
    }
}
