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
