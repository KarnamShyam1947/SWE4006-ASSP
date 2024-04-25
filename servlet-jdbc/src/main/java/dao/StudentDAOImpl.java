package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Student;

public class StudentDAOImpl implements StudentDAO {

    private final String SELECT_QUERY = "SELECT * FROM student";
    private final String DELETE_TOP_QUERY = "DELETE FROM student LIMIT 1";
    private final String DELETE_QUERY = "DELETE FROM student WHERE reg_no=?";
    private final String SELECT_QUERY_BY_ROLL = "SELECT * FROM student WHERE reg_no=?";
    private final String UPDATE_QUERY = "UPDATE student SET name=?, email=?, phone=? WHERE reg_no=?";
    private final String INSERT_QUERY = "INSERT INTO student(name, email, phone, reg_no) values(?, ?, ?, ?)";

    @Override
    public int addStudent(Student student) {
        int rows = 0;

        try {
            Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, student.getUsername());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getRegNo());
            rows = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int updateStudent(Student student) {
        int rows = 0;

        try {
            Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, student.getUsername());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getRegNo());
            rows = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int deleteStudent(String regNo) {
        int rows = 0;

        try {
            Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setString(1, regNo);

            rows = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT_QUERY);

            while (result.next()) {
                Student student = new Student();

                student.setUsername(result.getString("name"));
                student.setEmail(result.getString("email"));
                student.setPhone(result.getString("phone"));
                student.setRegNo(result.getString("reg_no"));
                student.setId(result.getInt("id"));

                students.add(student);
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student getStudentByRegNo(String regNo) {
        Student student = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_QUERY_BY_ROLL);
            statement.setString(1, regNo);
            ResultSet result = statement.executeQuery();

            student = new Student();

            while (result.next()) {
                student.setUsername(result.getString("name"));
                student.setEmail(result.getString("email"));
                student.setPhone(result.getString("phone"));
                student.setRegNo(result.getString("reg_no"));
                student.setId(result.getInt("id"));
            }

            result.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return student;
    }

    @Override
    public int deleteTopRecord() {
        int rows = 0;

        try {
            Connection connection = DatabaseUtils.getConnection();

            rows = connection
                    .createStatement()
                    .executeUpdate(DELETE_TOP_QUERY);

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rows;
    }

}
