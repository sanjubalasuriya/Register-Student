package com.abcinsitute.controller;

import com.abcinsitute.dto.StudentDto;
import com.abcinsitute.paginated.PaginatedResponseStudentDto;
import com.abcinsitute.service.StudentService;
import com.abcinsitute.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;



    //Save Student

    @PostMapping("")
    public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentDto studentDto){

        String message = studentService.saveStudent(studentDto);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",message), HttpStatus.CREATED);
    }

    //Update Student

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateStudent(@RequestBody StudentDto studentDto){
        String message = studentService.updateStudent(studentDto);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",message), HttpStatus.CREATED);

    }

    //Search Student Using Id

    @GetMapping("/{studentId}")
    public  ResponseEntity<StandardResponse> getStudentById(@PathVariable String studentId){

        StudentDto studentDto = studentService.findByStudentId(studentId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",studentDto), HttpStatus.OK);
    }



    //Delete Student

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable String id){
        String deleted = studentService.deleteStudent(id);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",deleted),HttpStatus.OK);
    }

    //Get All Student with Pagination

    @GetMapping(path = "/studentPagination",params = {"page","size"})
    public ResponseEntity<StandardResponse> getStudentsByPagination(@RequestParam(value = "page") int page,
                                                                  @RequestParam(value = "size") int size){

        PaginatedResponseStudentDto paginatedResponseStudentDto = studentService.findStudentsByPagination(page,size);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", paginatedResponseStudentDto), HttpStatus.OK) {
        };
    }


}
