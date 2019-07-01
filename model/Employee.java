package ir.maktab.HomeWork11_DataBase.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "emp_code")
    private String empCode;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private List<Address> addresses;

    //constructors

    public Employee() {
    }

    public Employee(String name, String empCode, Double salary) {
        this.name = name;
        this.empCode = empCode;
        this.salary = salary;
    }

    //setter and getter

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

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void print(){
        for(Address address : this.addresses){
            address.toString();
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empCode='" + empCode + '\'' +
                ", salary=" + salary +
                ", addresses=" + addresses +
                '}';
    }

}