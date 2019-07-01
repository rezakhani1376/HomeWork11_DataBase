package ir.maktab.HomeWork11_DataBase.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tel_numbers")
    private Long telNumber;

    @Column(name = "mobile_numbers")
    private Long mobileNumber;

    public PhoneNumber() {

    }

    public PhoneNumber(Long telNumber, Long mobileNumber) {
        this.telNumber = telNumber;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", telNumber=" + telNumber +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}