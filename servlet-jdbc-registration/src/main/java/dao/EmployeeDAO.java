package dao;

import java.util.List;

import models.Employee;

public interface EmployeeDAO {
    public int addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

}
