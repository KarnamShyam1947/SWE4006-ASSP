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

    private final String COUNT_QUERY = "SELECT count(*) FROM student";
    private final String SELECT_QUERY = "SELECT * FROM student";
    private final String PAGINATE_QUERY = "SELECT * FROM student LIMIT ? OFFSET ?; ";

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
    public List<Student> getStudentPage(int page, int perPage) {
        List<Student> students = new ArrayList<>();

        try {
            Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(PAGINATE_QUERY);

            int offset = (page - 1) * perPage;

            statement.setInt(1, perPage); // limit
            statement.setInt(2, offset); // offset 

            ResultSet result = statement.executeQuery();

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
    public int getStudentCount() {
        int cnt = -1;
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(COUNT_QUERY);
            
            while (result.next()) 
                cnt = result.getInt(1);
            
            result.close();
            statement.close();
            connection.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt;
    }

}
