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
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.JobSkillService;

import java.util.List;

@RestController
@RequestMapping("api/v1/job-skill")
@Slf4j
public class JobSkillResource implements IManagement<JobSkill, JobSkillId> {

    @Autowired
    private JobSkillService jss;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody JobSkill jobSkill) {
        log.info("Call JobSkill insert");
        log.info("Received JobSkill: {}", jobSkill.getId().getJob().getJobName()+ " " + jobSkill.getId().getSkill().getSkillName());
        try{
            JobSkill output = jss.add(jobSkill);
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
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity<Response> update(JobSkillId jobSkillId, JobSkill jobSkill) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Response> delete(JobSkillId jobSkillId) {
        return null;
    }

    @Override
    public ResponseEntity<Response> findById(JobSkillId jobSkillId) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return null;
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
