package com.abcinsitute.service.impl;

import com.abcinsitute.dto.StudentDto;
import com.abcinsitute.exception.DuplicateKeyException;
import com.abcinsitute.exception.NotFoundException;
import com.abcinsitute.model.Student;
import com.abcinsitute.paginated.PaginatedResponseStudentDto;

import com.abcinsitute.repo.StudentRepo;
import com.abcinsitute.service.StudentService;
import com.abcinsitute.util.mapper.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    //Save Student

    @Override
    public String saveStudent(StudentDto studentDto) {

        Student student = modelMapper.map(studentDto, Student.class);
        if (!studentRepo.existsById(student.getStudentId())) {
            studentRepo.save(student);
            return student.getStudentId() + " saved successfully";
        } else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    //Update Student

    @Override
    public String updateStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        if (studentRepo.existsById(studentDto.getStudentId())){
            studentRepo.save(student);
            return student.getStudentId() + " saved successfully";
        }else {
            throw new NotFoundException("Student does not exist");
        }
    }

    //Search by Id

    @Override
    public StudentDto findByStudentId(String studentId) {
        if(studentRepo.existsById(studentId)){
            Student student = studentRepo.getReferenceById(studentId);
            StudentDto studentDto = modelMapper.map(student,StudentDto.class);
            return studentDto;
        }else {
            throw new NotFoundException("No data");
        }
    }

    //Delete

    @Override
    public String deleteStudent(String id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Deleted successfully "+id;
        }else {
            throw new NotFoundException("Does not found Student");
        }
    }

    //Get All Pagination

    @Override
    public PaginatedResponseStudentDto findStudentsByPagination(int page, int size) {
        Page<Student> students=studentRepo.findAll(PageRequest.of(page, size));

        if(students.getSize()<1){
            throw new NotFoundException("No Data");
        }
        PaginatedResponseStudentDto paginatedResponseStudentDto = new PaginatedResponseStudentDto(
                listMapper.studentListToPage(students),
                (int) studentRepo.count()
        );
        return paginatedResponseStudentDto;

    }




}
