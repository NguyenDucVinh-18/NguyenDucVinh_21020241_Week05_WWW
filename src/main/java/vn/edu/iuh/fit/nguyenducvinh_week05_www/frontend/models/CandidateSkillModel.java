package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;

import java.io.IOException;
import java.util.List;


@Component
public class CandidateSkillModel {
    private final RestTemplate rt = new RestTemplate();
    private final String uri = "http://localhost:8080/api/v1/candidate-skill";
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

//    public List<JobSkill> getAllJobsBySkill(Long skillId) {
//        ResponseEntity<String> responseEntity = rt.getForEntity(uri + "/jobs/" + skillId, String.class);
//        String json = responseEntity.getBody();
//
//        try {
//            JsonNode root = mapper.readTree(json);
//            JsonNode dataNode = root.path("data");
//            return mapper.readValue(dataNode.toString(), new TypeReference<List<JobSkill>>() {});
//        } catch (IOException e) {
//            throw new RuntimeException("Error parsing response", e);
//        }
//    }

    public List<CandidateSkill> getAllSkillByCan(Long canId){
        ResponseEntity<String> responseEntity = rt.getForEntity(uri + "/skills/" + canId, String.class);
        String json = responseEntity.getBody();

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode dataNode = root.path("data");
            return mapper.readValue(dataNode.toString(), new TypeReference<List<CandidateSkill>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    public List<CandidateSkill> getAllCandidateSkillBySkill(Long skillId) {
        ResponseEntity<String> responseEntity = rt.getForEntity(uri + "/candidates/" + skillId, String.class);
        String json = responseEntity.getBody();

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode dataNode = root.path("data");
            return mapper.readValue(dataNode.toString(), new TypeReference<List<CandidateSkill>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    public CandidateSkill addCandidateSkill(CandidateSkill candidateSkill) {
        ResponseEntity<String> responseEntity = rt.postForEntity(uri, candidateSkill, String.class);
        String json = responseEntity.getBody();

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode dataNode = root.path("data");
            return mapper.readValue(dataNode.toString(), CandidateSkill.class);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }
}
