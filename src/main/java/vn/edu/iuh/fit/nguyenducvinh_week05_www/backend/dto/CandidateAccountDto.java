package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateAccountDto {
    private String email;
    private String password;
}
