package ir.maktab.HomeWork11_DataBase.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "postal_address")
    private String postalAddress;

    @Column(name = "city")
    private String city;

    @ManyToOne
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private List<PhoneNumber> phoneNumberList;

    //constructors

    public Address() {
    }

    public Address(String postalCode, String postalAddress, String city, Employee employee, List<PhoneNumber> phoneNumberList) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.employee = employee;
        this.phoneNumberList = phoneNumberList;
    }

    //setter and getter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public List<PhoneNumber> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumberList=" + phoneNumberList +
                '}';
    }
}
