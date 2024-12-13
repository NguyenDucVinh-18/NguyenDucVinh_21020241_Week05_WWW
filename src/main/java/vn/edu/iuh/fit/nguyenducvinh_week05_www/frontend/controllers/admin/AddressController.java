package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Address;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models.AddressModel;

@Controller
@RequestMapping("/admin-fe/address-management")
public class AddressController {

    @Autowired
    private AddressModel am;

    @PostMapping
    public ModelAndView addAddress(
            @RequestParam("inputStreet") String street,
            @RequestParam("inputCity") String city,
            @RequestParam("inputCountry") Short contry,
            @RequestParam("inputNumber") String number,
            @RequestParam("inputZipcode") String zipcode,
            ModelAndView mv
    ) {
        mv.setViewName("redirect:/admin-fe/address-management");
        Address address = new Address(street, city, contry, number, zipcode);
        am.addAddress(address);
        return mv;
    }
}
