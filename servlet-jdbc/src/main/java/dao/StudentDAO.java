package dao;

import java.util.List;

import models.Student;

public interface StudentDAO {
    public Student getStudentByRegNo(String regNo);

    public int updateStudent(Student student);

    public int deleteStudent(String regNo);

    public int addStudent(Student student);

    public List<Student> getAllStudents();

    public int deleteTopRecord();

}
