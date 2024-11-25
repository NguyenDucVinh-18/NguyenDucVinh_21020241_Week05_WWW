package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int code;
    private String message;
    private Object data;
}
