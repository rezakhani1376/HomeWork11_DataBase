package ir.maktab.HomeWork11_DataBase.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "empCode")
    private int empCode;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST})
    private List<Address> address;

    public Employee() {

    }

    public Employee(String name, int empCode, Double salary) {
        this.name = name;
        this.empCode = empCode;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (this.address == null) {
            this.address=new ArrayList<Address>();
        }
        this.address.add(address);
        address.setEmployee(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empCode=" + empCode +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}