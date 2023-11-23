package com.jake.mongodb.controller;

import com.jake.mongodb.dto.StudentDto;
import com.jake.mongodb.mapper.StudentMapper;
import com.jake.mongodb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/student/all")
    public List<StudentDto> findAllStudents() {
        return studentService.findAllStudents().stream()
                .map(studentMapper::fromStudent).collect(Collectors.toList());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable String id) {

        var student = studentService.findStudentById(id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }

        var foundStudent = studentMapper.fromStudent(student);
        return ResponseEntity.ok(foundStudent);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
        var studentToInsert = studentMapper.toStudent(studentDto);
        var insertedStudent = studentService.insertStudent(studentToInsert);
        var insertedStudentDto = studentMapper.fromStudent(insertedStudent);
        return ResponseEntity.ok(insertedStudentDto);
    }
}
