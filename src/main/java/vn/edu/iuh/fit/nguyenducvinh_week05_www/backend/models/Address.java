package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "works")
@NoArgsConstructor
public class Address {
    @Setter
    @Getter
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", length = 150)
    @NonNull
    private String street;

    @Column(name = "city", length = 50)
    @NonNull
    private String city;

    @Column(name = "country")
    @NonNull
    private Short country;

    @Column(name = "number", length = 20)
    @NonNull
    private String number;

    @Column(name = "zipcode", length = 7)
    @NonNull
    private String zipcode;

    public Address( String street,  String city,  Short country,  String number,  String zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }


    public @NonNull String getStreet() {
        return street;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    public @NonNull String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    public @NonNull Short getCountry() {
        return country;
    }

    public void setCountry(@NonNull Short country) {
        this.country = country;
    }

    public @NonNull String getNumber() {
        return number;
    }

    public void setNumber(@NonNull String number) {
        this.number = number;
    }

    public @NonNull String getZipcode() {
        return zipcode;
    }

    public void setZipcode(@NonNull String zipcode) {
        this.zipcode = zipcode;
    }
}