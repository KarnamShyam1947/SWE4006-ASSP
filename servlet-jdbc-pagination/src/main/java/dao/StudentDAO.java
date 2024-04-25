package dao;

import java.util.List;

import models.Student;

public interface StudentDAO {
    public int getStudentCount();
    public List<Student> getAllStudents();
    public List<Student> getStudentPage(int page, int perPage);
}
