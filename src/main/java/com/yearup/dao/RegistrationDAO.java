package com.yearup.dao;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import com.yearup.model.Student;

public interface RegistrationDAO {
    public Long persistStudent(Student student);

    public Student findById(Long id);
}