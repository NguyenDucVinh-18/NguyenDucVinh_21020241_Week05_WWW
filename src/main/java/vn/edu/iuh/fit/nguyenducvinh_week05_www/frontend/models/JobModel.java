package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Company;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Component
public class JobModel {
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private RestTemplate rt = new RestTemplate();
    private final String  uri = "http://localhost:8080/api/v1/job";

    public List<Job> findListJobByCompanyId(Long id){
        ResponseEntity<String> responseEntity = rt.getForEntity(uri + "/ListJobs/" + id, String.class);
        String json = responseEntity.getBody();

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode dataNode = root.path("data");
            return mapper.readValue(dataNode.toString(), new TypeReference<List<Job>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error parsing response", e);
        }
    }

    public Job addJob(Job job){
        Response response = rt.postForObject(URI.create(uri), job, Response.class);
        return mapper.convertValue(response.getData(), Job.class);
    }
}
