package ir.maktab.HomeWork11_DataBase;

import ir.maktab.HomeWork11_DataBase.model.Address;
import ir.maktab.HomeWork11_DataBase.model.Employee;
import ir.maktab.HomeWork11_DataBase.model.PhoneNumber;
import ir.maktab.HomeWork11_DataBase.model.dao.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        EmployeeDao employeeDAO = new EmployeeDaoImpl(factory);
        /*AddressDao addressDao =new AddressDaoImpl(factory);
        PhoneNumberDao phoneNumberDao=new PhoneNumberDaoImpl(factory);*/
        Session session = factory.openSession();

        PhoneNumber phoneNumber1 = new PhoneNumber(26523656L, 60345654L);
        PhoneNumber phoneNumber2 = new PhoneNumber(26598656L, 5195654L);
        PhoneNumber phoneNumber3 = new PhoneNumber(26523233L, 12345654L);
        PhoneNumber phoneNumber4 = new PhoneNumber(26522346L, 45345654L);
        PhoneNumber phoneNumber5 = new PhoneNumber(26589716L, 78645654L);

        Address address1 = new Address(1235L, "Kooche folan", "Tehran");
        Address address2 = new Address(1233L, "Kooche bahman", "Alborz");
        Address address3 = new Address(1237L, "Kooche dkfdf", "Mashhad");
        Address address4 = new Address(1239L, "Kooche dsfgfdf", "Tabriz");
        Address address5 = new Address(1231L, "Kooche ghghgh", "Karaj");

        address1.addPhoneNumber(phoneNumber1);
        address2.addPhoneNumber(phoneNumber2);
        address3.addPhoneNumber(phoneNumber3);
        address4.addPhoneNumber(phoneNumber4);
        address5.addPhoneNumber(phoneNumber5);

        Employee employee1 = new Employee("Ali", 1234, 200000D);
        Employee employee2 = new Employee("Mohsen", 1235, 230000D);
        Employee employee3 = new Employee("Mohammad", 1236, 180000D);
        Employee employee4 = new Employee("Fateme", 1237, 75000D);
        Employee employee5 = new Employee("Maryam", 1238, 98000D);

        employee1.setAddress(address1);
        employee2.setAddress(address2);
        employee3.setAddress(address3);
        employee4.setAddress(address4);
        employee5.setAddress(address5);


        employeeDAO.create(employee1);
        employeeDAO.create(employee2);
        employeeDAO.create(employee3);
        employeeDAO.create(employee4);
        employeeDAO.create(employee5);

       /* List<Employee> salary =((EmployeeDaoImpl) employeeDAO).maxSalaryBaseOnCity("Tehran");*/

        Employee employee = (Employee) ((EmployeeDaoImpl) employeeDAO).maxSalaryBaseOnCity("Tehran");
        Employee employeePostalCode = (Employee) ((EmployeeDaoImpl) employeeDAO).findByPostalCode(1233L);
        Employee employeeTelNumber = (Employee) ((EmployeeDaoImpl) employeeDAO).findByPhoneNumber(9812L);

        /*System.out.println(salary);*/
        System.out.println(employee);
        System.out.println(employeePostalCode);
        System.out.println(employeeTelNumber);


        factory.close();
    }
}

