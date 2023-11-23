package com.jake.mongodb.service;

import com.jake.mongodb.document.Student;
import com.jake.mongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepo.insert(student);
    }
}
