package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company", schema = "works")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Company {
    @Id
    @Column(name = "comp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "about", length = 2000)
    private String about;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "comp_name", nullable = false)
    private String compName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "web_url")
    private String webUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    public Company(String about, String email, String password, String compName, String phone, String webUrl, Address address) {
        this.about = about;
        this.email = email;
        this.password = password;
        this.compName = compName;
        this.phone = phone;
        this.webUrl = webUrl;
        this.address = address;
    }
}