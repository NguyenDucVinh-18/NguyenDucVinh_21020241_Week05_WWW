package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Component
public class JobSkillModel {

    private final RestTemplate rt = new RestTemplate();
    private final String uri = "http://localhost:8080/api/v1/job-skill";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<JobSkill> getAllJobsBySkill(Long skillId) {
        ResponseEntity<String> responseEntity = rt.getForEntity(uri + "/jobs/" + skillId, String.class);
        String json = responseEntity.getBody();

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode dataNode = root.path("data");
            return mapper.readValue(dataNode.toString(), new TypeReference<List<JobSkill>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

}