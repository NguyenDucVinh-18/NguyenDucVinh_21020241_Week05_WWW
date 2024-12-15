package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.CandidateSkillService;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate-skill")
@Slf4j
public class CandidateSkillResource implements IManagement<CandidateSkill, CandidateSkillId> {

    @Autowired
    private CandidateSkillService css;


    @Override
    public ResponseEntity<Response> insert(CandidateSkill candidateSkill) {
        CandidateSkill savedCandidateSkill = css.add(candidateSkill);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(
                HttpStatus.CREATED.value(),
                "CandidateSkill created successfully",
                savedCandidateSkill
        ));
    }

    @Override
    public ResponseEntity<Response> insertAll(List<CandidateSkill> t) {
        return null;
    }

    @Override
    public ResponseEntity<Response> update(CandidateSkillId candidateSkillId, CandidateSkill candidateSkill) {
        return null;
    }

    @Override
    public ResponseEntity<Response> delete(CandidateSkillId candidateSkillId) {
        return null;
    }

    @Override
    public ResponseEntity<Response> findById(CandidateSkillId candidateSkillId) {
        return null;
    }

    @Override
    public ResponseEntity<Response> findAll() {
        return null;
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
