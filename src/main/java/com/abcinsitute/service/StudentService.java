package com.abcinsitute.service;

import com.abcinsitute.dto.StudentDto;
import com.abcinsitute.paginated.PaginatedResponseStudentDto;

import java.util.List;

public interface StudentService {
    String saveStudent(StudentDto studentDto);

    StudentDto findByStudentId(String studentId);

    String deleteStudent(String id);

    PaginatedResponseStudentDto findStudentsByPagination(int page, int size);

    String updateStudent(StudentDto studentDto);


}
