package com.jake.mongodb.mapper;

import com.jake.mongodb.document.Student;
import com.jake.mongodb.dto.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentDto studentDto);

    StudentDto fromStudent(Student student);
}
