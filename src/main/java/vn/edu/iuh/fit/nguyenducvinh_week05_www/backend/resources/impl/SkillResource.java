package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.SkillService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/skill")
@Slf4j
public class SkillResource implements IManagement<Skill, Long> {

    @Autowired
    private SkillService ss;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Skill skill) {
        log.info("Call skill insert");
        try{
            Skill output = ss.add(skill);
            log.info("Insert skill success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert skill success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert skill fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert skill fail",
                    skill
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong,@RequestBody Skill skill) {
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
        log.info("Calling get skill by id " + aLong);
        try{
            Optional<Skill> skill = ss.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "Get skill by id " + aLong + " success",
                    skill.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found skill by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found skill by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.warn("Skill by id " + aLong + " fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Skill by id " + aLong + " fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response(
           HttpStatus.OK.value(),
           "Get all skill success",
           ss.getAll()
        ));
    }
}
