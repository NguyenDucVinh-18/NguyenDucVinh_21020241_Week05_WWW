package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.JobService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job")
@Slf4j
public class JobResource implements IManagement<Job, Long> {

    @Autowired
    private JobService js;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Job job) {
        log.info("Call job insert");
        try{
            Job output = js.add(job);
            log.info("Insert job success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert job success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert job fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert job fail",
                    null
            ));
        }
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<Job> t) {
        log.info("Call list job insert");
        try{
            List<Job> output = js.addMany(t);
            log.info("Insert list job success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list job success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert list job fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list job fail",
                    null
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong,@RequestBody Job job) {
        log.info("Call job update");
        try{
            Job output = js.update(job);
            log.info("Update job success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update job success",
                    output
            ));
        } catch (Exception e) {
            log.error("Update job fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update job fail",
                    null
            ));
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) {
        log.info("Call job delete");
        try{
            js.delete(aLong);
            log.info("Delete job success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Delete job success",
                    null
            ));
        } catch (Exception e) {
            log.error("Delete job fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Delete job fail",
                    null
            ));
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") Long aLong) {
        log.info("Calling get job by id " + aLong);
        try{
            Optional<Job> job = js.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "Get job by id " + aLong + " success",
                    job.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found job by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found job by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.warn("Job by id " + aLong + " fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Job by id " + aLong + " fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all job success",
                js.getAll()
        ));
    }

    @GetMapping("/ListJobs/{id}")
    public ResponseEntity<Response> getByCompanyId(@PathVariable("id") Long id){
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get job by company id " + id + " success",
                js.getByCompanyId(id)
        ));
    }
}
