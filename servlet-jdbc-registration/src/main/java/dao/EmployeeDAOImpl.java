package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Employee;
import utils.DatabaseUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String SELECT_QUERY = "SELECT * FROM employee";
    private final String INSERT_QUERY = "INSERT INTO employee(name, email, phone, address, password) values(?, ?, ?, ?, ?)";

    @Override
    public int addEmployee(Employee employee) {
        int rows = 0;

        try {
            Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getAddress());
            statement.setString(5, employee.getPassword());
            rows = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT_QUERY);

            while (result.next()) {
                Employee employee = new Employee();

                employee.setName(result.getString("name"));
                employee.setEmail(result.getString("email"));
                employee.setPhone(result.getString("phone"));
                employee.setAddress(result.getString("address"));
                employee.setId(result.getInt("id"));

                employees.add(employee);
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

}
