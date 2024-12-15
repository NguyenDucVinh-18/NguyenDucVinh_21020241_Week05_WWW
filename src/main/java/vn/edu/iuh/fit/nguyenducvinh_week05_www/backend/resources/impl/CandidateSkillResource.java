package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.CandidateSkillService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/candidate-skill")
@Slf4j
public class CandidateSkillResource implements IManagement<CandidateSkill, CandidateSkillId> {

    @Autowired
    private CandidateSkillService css;


    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody CandidateSkill candidateSkill) {
        CandidateSkill savedCandidateSkill = css.add(candidateSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(
                HttpStatus.CREATED.value(),
                "CandidateSkill created successfully",
                savedCandidateSkill
        ));
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<CandidateSkill> t) {
       List<CandidateSkill> savedCandidateSkills = css.addMany(t);
         return ResponseEntity.status(HttpStatus.CREATED).body(new Response(
                HttpStatus.CREATED.value(),
                "CandidateSkills created successfully",
                savedCandidateSkills
         ));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") CandidateSkillId candidateSkillId, @RequestBody CandidateSkill candidateSkill) {
        CandidateSkill updatedCandidateSkill = css.update(candidateSkill);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(
                HttpStatus.OK.value(),
                "CandidateSkill updated successfully",
                updatedCandidateSkill
        ));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") CandidateSkillId candidateSkillId) {
        css.delete(candidateSkillId);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(
                HttpStatus.OK.value(),
                "CandidateSkill deleted successfully",
                null
        ));
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findById(CandidateSkillId candidateSkillId) {
        Optional<CandidateSkill> candidateSkill = css.getById(candidateSkillId);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(
                HttpStatus.OK.value(),
                "CandidateSkill found successfully",
                candidateSkill
        ));
    }

    @GetMapping("/all")
    @Override
    public ResponseEntity<Response> findAll() {
        List<CandidateSkill> candidateSkills = css.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new Response(
                HttpStatus.OK.value(),
                "CandidateSkills found successfully",
                candidateSkills
        ));
    }

    @GetMapping("/skills/{canId}")
    public ResponseEntity<Response> getAllSkillByCanId(@PathVariable("canId") Long canId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all skill for candidate id",
                css.getAllSkillByCanId(canId)
        ));
    }

    @GetMapping("/candidates/{skillId}")
    public ResponseEntity<Response> getAllCanBySkillId(@PathVariable("skillId") Long skillId) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all candidate by skill id",
                css.getAllCanBySkillId(skillId)
        ));
    }
}
