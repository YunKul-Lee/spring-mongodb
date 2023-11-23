package com.jake.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private String id;
    private String name;
    private String lastName;
    private int age;
    private String email;

}
