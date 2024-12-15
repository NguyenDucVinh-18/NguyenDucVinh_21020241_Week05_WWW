package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.JobSkillService;

import java.util.List;

@RestController
@RequestMapping("api/v1/job-skill")
@Slf4j
public class JobSkillResource implements IManagement<JobSkill, JobSkillId> {

    @Autowired
    private JobSkillService jss;

    @Autowired
    private JobSkillRepository jsr;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody JobSkill jobSkill) {
        log.info("Call JobSkill insert");
        log.info("Received JobSkill: {}", jobSkill.getId().getJob().getJobName()+ " " + jobSkill.getId().getSkill().getSkillName());
        try{
//            JobSkill output = jss.add(jobSkill);
            JobSkill output = jsr.save(jobSkill);
            log.info("Insert JobSkill success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert JobSkill success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert JobSkill fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert JobSkill fail",
                    null
            ));
        }

    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<JobSkill> list) {
        log.info("Call list JobSkill insert");
        try{
            List<JobSkill> output = jsr.saveAll(list);
            log.info("Insert list JobSkill success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list JobSkill success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert list JobSkill fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list JobSkill fail",
                    null
            ));
        }

    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") JobSkillId jobSkillId,@RequestBody JobSkill jobSkill) {
        log.info("Call JobSkill update");
        try{
            JobSkill output = jsr.save(jobSkill);
            log.info("Update JobSkill success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update JobSkill success",
                    output
            ));
        } catch (Exception e) {
            log.error("Update JobSkill fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Update JobSkill fail",
                    null
            ));
        }

    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") JobSkillId jobSkillId) {
        log.info("Call JobSkill delete");
        try{
            jsr.deleteById(jobSkillId);
            log.info("Delete JobSkill success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Delete JobSkill success",
                    null
            ));
        } catch (Exception e) {
            log.error("Delete JobSkill fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Delete JobSkill fail",
                    null
            ));
        }

    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") JobSkillId jobSkillId) {
        log.info("Call JobSkill find by id");
        try{
            JobSkill output = jsr.findById(jobSkillId).get();
            log.info("Find JobSkill by id success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Find JobSkill by id success",
                    output
            ));
        } catch (Exception e) {
            log.error("Find JobSkill by id fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Find JobSkill by id fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        log.info("Call JobSkill find all");
        try{
            List<JobSkill> output = jsr.findAll();
            log.info("Find all JobSkill success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Find all JobSkill success",
                    output
            ));
        } catch (Exception e) {
            log.error("Find all JobSkill fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Find all JobSkill fail",
                    null
            ));
        }
    }


    @GetMapping("/jobs/{skillId}")
    public ResponseEntity<Response> getAllJobsBySkill(@PathVariable("skillId") Long skillId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all jobs by skill id",
                jss.getAllJobsBySkill(skillId)
        ));
    }

    @GetMapping("/jobSkill/{jobId}")
    public ResponseEntity<Response> getAllJobSkillByJob(@PathVariable("jobId") Long jobId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all jobs by job id",
                jss.getAllJobSkillByJob(jobId)
        ));
    }

    @GetMapping("/jobs={jobId}/skills={skillId}")
    public ResponseEntity<Response> getJobSkillByJobIdAndSkillId(@PathVariable("jobId") Long jobId, @PathVariable("skillId") Long skillId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get job skill by job id and skill id",
                jss.getAllJobsByJobAndSkill(jobId, skillId)
        ));
    }
}
