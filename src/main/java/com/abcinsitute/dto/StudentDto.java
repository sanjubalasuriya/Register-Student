package com.abcinsitute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private String studentId;
    private String name;
    private String address;
    private String contact;
}
