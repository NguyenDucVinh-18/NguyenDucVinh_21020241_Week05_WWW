package vn.edu.iuh.fit.nguyenducvinh_week05_www.frontend.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Company;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;

import java.net.URI;

@Component
public class CompanyModel {
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private RestTemplate rt = new RestTemplate();
    private final String  uri = "http://localhost:8080/api/v1/company";

    public Company getCompanyById(Long id){
        Response response = rt.getForObject(URI.create(uri + "/" + id), Response.class);
        return mapper.convertValue(response.getData(), Company.class);
    }

    public Company addCompany(Company company){
        Response response = rt.postForObject(URI.create(uri), company, Response.class);
        return mapper.convertValue(response.getData(), Company.class);
    }
}
