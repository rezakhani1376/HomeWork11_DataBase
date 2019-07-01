package ir.maktab.HomeWork11_DataBase.model.dao;


import ir.maktab.HomeWork11_DataBase.Base.BaseDao;
import ir.maktab.HomeWork11_DataBase.model.Employee;


public interface EmployeeDao extends BaseDao<Employee> {

    Double maxSalaryByCity(String city);

    Employee employeeMaxSalaryByCity(String city);

    Employee findEmpByPostalCode(String postalCode);

    Employee findEmpByTelNumber(String telNumber);
}
