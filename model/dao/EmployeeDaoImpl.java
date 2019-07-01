package ir.maktab.HomeWork11_DataBase.model.dao;

import ir.maktab.HomeWork11_DataBase.Base.BaseDaoImpl;
import ir.maktab.HomeWork11_DataBase.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

    public EmployeeDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntityName() {
        return "Employee";
    }


        public List<Employee> maxSalaryBaseOnCity(String str){
        Session session = factory.openSession();

        List<Employee> employees = new ArrayList<>();

        employees = session.createQuery("select e.address.city, MAX(salary) from  Employee e where e.address.city =:str")
                .setParameter("str", str)
                .getResultList();


        session.close();

        return employees;
    }

    public List<Employee> findByPostalCode(Long postalCode){
        Session session = factory.openSession();

        List<Employee> employees;

        employees = session.createQuery("from Employee e where e.address.postalCode =:postalCode")
                .setParameter("postalCode", postalCode)
                .getResultList();;

        session.close();

        return employees;
    }

    public List<Employee> findByPhoneNumber(Long phoneNumber){
        Session session = factory.openSession();

        List<Employee> employees;

        employees = session.createQuery("from Employee e where e.phoneNumber.mobileNumber =:phoneNumber")
                .setParameter("phoneNumber", phoneNumber)
                .getResultList();

        session.close();

        return employees;
    }
}