package com.jake.mongodb.service;

import com.jake.mongodb.document.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    Student findStudentById(String id);

    Student insertStudent(Student student);
}
