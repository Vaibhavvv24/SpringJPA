package com.example.crudfirst.dao;

import com.example.crudfirst.entity.Student;

import java.util.List;

public interface Studentdao {
    public void save(Student student);
    public Student getById(int id);

    public List<Student> findAll();

    public List<Student> findbyfirstName(String fname);

    public void updateStudent(Student s);

    public void deleteStudent(int id);

    public  int deleteAll();
}
