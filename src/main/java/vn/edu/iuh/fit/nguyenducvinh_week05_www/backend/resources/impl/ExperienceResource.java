package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Experience;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.ExperienceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/experience")
@Slf4j
public class ExperienceResource implements IManagement<Experience, Long> {

    @Autowired
    private ExperienceService es;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Experience experience) {
        log.info("Call experience insert");
        try{
            Experience output = es.add(experience);
            log.info("Insert experience success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert experience success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert experience fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert experience fail",
                    null
            ));
        }
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody  List<Experience> t) {
        log.info("Call list experience insert");
        try{
            List<Experience> output = es.addMany(t);
            log.info("Insert list experience success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list experience success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert list experience fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list experience fail",
                    null
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong, @RequestBody Experience experience) {
        log.info("Call experience update");
        try{
            Experience output = es.update(experience);
            log.info("Update experience success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update experience success",
                    output
            ));
        } catch (Exception e) {
            log.error("Update experience fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update experience fail",
                    null
            ));
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) {
        log.info("Call experience delete");
        try{
            es.delete(aLong);
            log.info("Delete experience success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Delete experience success",
                    null
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found experience by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found experience by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.error("Delete experience fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Delete experience fail",
                    null
            ));
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") Long aLong) {
        log.info("Calling get experience by id " + aLong);
        try{
            Optional<Experience> experience = es.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "Get experience by id " + aLong + " success",
                    experience.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found experience by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found experience by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.warn("Experience by id " + aLong + " fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Experience by id " + aLong + " fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all experience success",
                es.getAll()
        ));
    }
}
