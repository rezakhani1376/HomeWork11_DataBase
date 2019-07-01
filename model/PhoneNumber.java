package ir.maktab.HomeWork11_DataBase.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "mob_number")
    private String mobNumber;

    //constructors

    public PhoneNumber() {
    }

    public PhoneNumber(String telNumber, String mobNumber) {
        this.telNumber = telNumber;
        this.mobNumber = mobNumber;
    }

    //setter and getter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", telNumber='" + telNumber + '\'' +
                ", mobNumber='" + mobNumber + '\'' +
                '}';
    }
}