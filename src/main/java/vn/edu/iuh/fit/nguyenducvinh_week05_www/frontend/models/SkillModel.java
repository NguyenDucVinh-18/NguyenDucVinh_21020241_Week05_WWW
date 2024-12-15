package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;

import java.net.URI;
import java.util.List;

@Component
public class SkillModel {
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private RestTemplate rt = new RestTemplate();
    private final String  uri = "http://localhost:8080/api/v1/skill";

    public Skill addSkill(Skill skill){
        Response response = rt.postForObject(URI.create(uri), skill, Response.class);
        return mapper.convertValue(response.getData(), Skill.class);
    }

    public List<Skill> getAllSkills() {
        Response response = rt.getForObject(URI.create(uri), Response.class);
        return mapper.convertValue(response.getData(), new TypeReference<List<Skill>>() {});
    }

    public Skill getSkillById(Long id) {
        Response response = rt.getForObject(uri + "/" + id, Response.class);
        return mapper.convertValue(response.getData(), Skill.class);
    }
}
