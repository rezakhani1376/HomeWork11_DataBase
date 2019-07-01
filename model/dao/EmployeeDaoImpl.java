package ir.maktab.HomeWork11_DataBase.model.dao;

import ir.maktab.HomeWork11_DataBase.Base.BaseDaoImpl;
import ir.maktab.HomeWork11_DataBase.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

    private final SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory){

        super(factory);
        this.factory = factory;
    }
    @Override
    protected String getEntityName() {
        return "Employee";
    }

    @Override
    public Double maxSalaryByCity(String city) {
        Session session = factory.openSession();

        Double salaryByCity =(Double) session.createQuery("select max(emp.salary) from Employee emp join emp.addresses add where add.city =:c ")
                .setParameter("c",city).uniqueResult();

        session.close();

        return salaryByCity;
    }

    @Override
    public Employee employeeMaxSalaryByCity(String city) {
        Session session = factory.openSession();

        Employee employee =(Employee) session.createQuery("select emp from Employee emp where emp.salary = (select max(e.salary) from Employee e join e.addresses addr where addr.city=:c)")
                .setParameter("c",city).getSingleResult();

        session.close();

        return employee;
    }

    @Override
    public Employee findEmpByPostalCode(String postalCode) {
        Session session = factory.openSession();

        Object employee = session.createQuery("select emp from Employee emp join emp.addresses add where add.postalCode=:p")
                .setParameter("p",postalCode).getSingleResult();

        Employee employee1 = (Employee) employee;

        session.close();

        return employee1;
    }

    @Override
    public Employee findEmpByTelNumber(String telNumber) {
        Session session = factory.openSession();

        Employee employee = (Employee) session.createQuery("select emp from Employee emp join emp.addresses add join add.phoneNumberList num where num.telNumber = :n" )
                .setParameter("n",telNumber).getSingleResult();

        session.close();

        return employee;
    }
}