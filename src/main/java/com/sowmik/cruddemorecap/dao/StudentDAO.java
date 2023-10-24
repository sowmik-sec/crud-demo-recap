package com.sowmik.cruddemorecap.dao;

import com.sowmik.cruddemorecap.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
