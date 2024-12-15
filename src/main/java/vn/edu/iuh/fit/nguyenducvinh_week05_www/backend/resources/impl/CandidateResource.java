package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.dto.CandidateAccountDto;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.CandidateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/candidate")
@Slf4j
public class CandidateResource implements IManagement<Candidate, Long> {

    @Autowired
    private CandidateService cs;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Candidate candidate) {
        log.info("Call candidate insert");
        try{
            Candidate output = cs.add(candidate);
            log.info("Insert candidate success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert candidate success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert candidate fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert candidate fail",
                    null
            ));
        }
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<Candidate> t) {
        log.info("Call list candidate insert");
        try{
            List<Candidate> output = cs.addMany(t);
            log.info("Insert list candidate success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list candidate success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert list candidate fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list candidate fail",
                    null
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long id, @RequestBody Candidate candidate) {
        log.info("Call candidate update with id: {}", id);
        try {
            candidate.setId(id); // Đảm bảo đối tượng Candidate chứa ID từ URL
            Candidate updatedCandidate = cs.update(candidate); // Gọi service cập nhật
            log.info("Update candidate success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update candidate success",
                    updatedCandidate
            ));
        } catch (Exception e) {
            log.error("Update candidate fail");
            log.error("Error: ", e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Update candidate fail",
                    null
            ));
        }
    }


    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") Long aLong) {
        log.info("Calling get candidate by id " + aLong);
        try{
            Optional<Candidate> candidate = cs.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "Get candidate by id " + aLong + " success",
                    candidate.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found candidate by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found candidate by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.warn("Candidate by id " + aLong + " fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Candidate by id " + aLong + " fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all candidate success",
                cs.getAll()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> checkLogin(@RequestBody CandidateAccountDto caDto){
        log.info("Call checkLogin");
        String email = caDto.getEmail();
        String password = caDto.getPassword();
        try{
            Candidate candidate = cs.checkLogin(email, password);
            if(candidate != null){
                log.info("Login success");
                return ResponseEntity.ok(new Response(
                        HttpStatus.OK.value(),
                        "Login success",
                        candidate
                ));
            } else {
                log.warn("Login fail for the email or password is incorrect!");
                return ResponseEntity.ok(new Response(
                        HttpStatus.NO_CONTENT.value(),
                        "Login fail for the email or password is incorrect!",
                        null
                ));
            }

        } catch (Exception e) {
            log.error("Login fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Login fail",
                    null
            ));
        }
    }
}
