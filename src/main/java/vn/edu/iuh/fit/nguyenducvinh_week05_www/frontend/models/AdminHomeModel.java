package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.*;

import java.net.URI;
import java.util.List;


@Component
public class AdminHomeModel {
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private RestTemplate rt = new RestTemplate();
    private final String  uri = "http://localhost:8080/api/v1/";

    public List<Skill> getAllSkills(){
        List<Skill> skills = null;

        Response response = rt.getForObject(URI.create(uri + "skill"), Response.class);
        skills = mapper.convertValue(response.getData(), new TypeReference<List<Skill>>() {});
        return skills;
    }

    public List<Candidate> getAllCandidates(){
        List<Candidate> candidates = null;

        Response response = rt.getForObject(URI.create(uri + "candidate"), Response.class);
        candidates = mapper.convertValue(response.getData(), new TypeReference<List<Candidate>>() {});
        return candidates;
    }

    public List<Address> getAllAddresses(){
        List<Address> addresses = null;

        Response response = rt.getForObject(URI.create(uri + "address"), Response.class);
        addresses = mapper.convertValue(response.getData(), new TypeReference<List<Address>>() {});
        return addresses;
    }

    public List<Company> getAllCompanies(){
        List<Company> companies = null;

        Response response = rt.getForObject(URI.create(uri + "company"), Response.class);
        companies = mapper.convertValue(response.getData(), new TypeReference<List<Company>>() {});
        return companies;
    }
}
