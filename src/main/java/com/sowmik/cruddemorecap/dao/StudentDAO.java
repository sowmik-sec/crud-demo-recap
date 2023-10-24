package com.sowmik.cruddemorecap.dao;

import com.sowmik.cruddemorecap.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
}
