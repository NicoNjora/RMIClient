package com.nicollet.rmiclient.services;

import com.nicollet.rmiclient.models.Student;

import java.util.Date;

public class StudentServiceImpl implements StudentService {
    @Override
    public String getStudentFullName(String firstName, String lastName) {
        System.out.println("================Server Side ========================");
        return "Your full name is:  " + firstName + " "+ lastName + " :: Response time - > " + new Date();
    }
}
