package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.CandidateService;

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
                    candidate
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong,@RequestBody Candidate candidate) {
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
}
