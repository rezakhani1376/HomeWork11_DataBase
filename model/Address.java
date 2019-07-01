package ir.maktab.HomeWork11_DataBase.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postalCode")
    private Long postaCode;

    @Column(name = "postalAddress")
    private String postalAddress;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private List<PhoneNumber> phoneNumber;

    public Address() {

    }

    public Address(Long postaCode, String postalAddress, String city) {
        this.postaCode = postaCode;
        this.postalAddress = postalAddress;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostaCode() {
        return postaCode;
    }

    public void setPostaCode(Long postaCode) {
        this.postaCode = postaCode;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<PhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumber> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postaCode=" + postaCode +
                ", postalAddress='" + postalAddress + '\'' +
                ", city='" + city + '\'' +
                ", employee=" + employee +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public void addPhoneNumber(PhoneNumber number) {
        if (this.phoneNumber == null) {
            this.phoneNumber = new ArrayList<>();
        }
        this.phoneNumber.add(number);
    }
}