package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.dto.CandidateAccountDto;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;

import java.net.URI;

@Component
public class AuthenticateModel {

    private ObjectMapper  mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private RestTemplate rt = new RestTemplate();
    private final String  uri = "http://localhost:8080/api/v1/candidate";

    public Candidate checkLogin(String email, String password){

        Candidate candidate = null;

        CandidateAccountDto dto = new CandidateAccountDto(email, password);
        Response response = rt.postForObject(URI.create(uri + "/login"),dto, Response.class);
        candidate = mapper.convertValue(response.getData(), new TypeReference<>() {});
        return candidate;
    }

    public boolean createAccount(Candidate candidate){
        Response responseCan = rt.postForObject(URI.create(uri), candidate, Response.class);
        return responseCan.getCode() == 200;
    }
}
