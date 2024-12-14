package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.dto.CompanyAccountDto;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Company;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")
@Slf4j
public class CompanyResource implements IManagement<Company, Long> {

    @Autowired
    private CompanyService cs;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Company company) {
        log.info("Call company insert");
        try{
            Company output = cs.add(company);
            log.info("Insert company success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert company success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert company fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert company fail",
                    null
            ));
        }
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody  List<Company> t) {
        log.info("Call list company insert");
        try{
            List<Company> output = cs.addMany(t);
            log.info("Insert list company success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list company success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert list company fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list company fail",
                    null
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong,@RequestBody Company company) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") Long aLong) {
        log.info("Calling get company by id " + aLong);
        try{
            Optional<Company> company = cs.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "Get company by id " + aLong + " success",
                    company.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found company by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found company by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.warn("Company by id " + aLong + " fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Company by id " + aLong + " fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all company success",
                cs.getAll()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> checkLogin(@RequestBody CompanyAccountDto caDto){
        log.info("Call company login");
        String email = caDto.getEmail();
        String password = caDto.getPassword();
        try{
            Company output = cs.checkLogin(email,password);
            if(output != null){
                log.info("Login company success");
                return ResponseEntity.ok(new Response(
                        HttpStatus.OK.value(),
                        "Login company success",
                        output
                ));
            } else {
                log.warn("Login company fail");
                return ResponseEntity.ok(new Response(
                        HttpStatus.NOT_FOUND.value(),
                        "Login company fail",
                        null
                ));
            }
        } catch (Exception e) {
            log.error("Login company fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Login company fail",
                    null
            ));
        }
    }
}
