package com.yearup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yearup.dao.RegistrationDAO;
import com.yearup.model.Student;

@Component
public class RegistrationService{
    private final RegistrationDAO registrationDAO;

    @Autowired
    public RegistrationService(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    public Long registerStudent(Student student) throws
            StudentAlreadyRegisteredException {
        if (this.registrationDAO.findById(student.getId())
                != null) {
            throw new StudentAlreadyRegisteredException();
        }
        return registrationDAO.persistStudent(student);
    }
}