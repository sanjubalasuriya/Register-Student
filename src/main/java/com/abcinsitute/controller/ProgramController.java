package com.abcinsitute.controller;

import com.abcinsitute.dto.ProgramDto;
import com.abcinsitute.dto.request.RequestProgramDto;
import com.abcinsitute.paginated.PaginatedResponseProgramDto;
import com.abcinsitute.service.ProgramService;
import com.abcinsitute.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/program")
@CrossOrigin
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @PostMapping("")
    public ResponseEntity<StandardResponse> saveProgram(@RequestBody ProgramDto programDto){
        String message = programService.saveProgram(programDto);

        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success",message), HttpStatus.CREATED);
    }

    //update program

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateProgram(@RequestBody ProgramDto programDto){
        String message = programService.updateProgram(programDto);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",message), HttpStatus.CREATED);

    }

    //Search Program Using Id

    @GetMapping("/{programId}")
    public  ResponseEntity<StandardResponse> getProgramById(@PathVariable String programId){

        ProgramDto programDto = programService.findByProgramId(programId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",programDto), HttpStatus.OK);
    }


    //Delete Student

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable String id){
        String deleted = programService.deleteProgram(id);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",deleted),HttpStatus.OK);
    }

    //Get All Student with Pagination

    @GetMapping(path = "/programPagination",params = {"page","size"})
    public ResponseEntity<StandardResponse> getProgramsByPagination(@RequestParam(value = "page") int page,
                                                                    @RequestParam(value = "size") int size){

        PaginatedResponseProgramDto paginatedResponseProgramDto = programService.findProgramsByPagination(page,size);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Success", paginatedResponseProgramDto), HttpStatus.OK) {
        };
    }

    @PostMapping("/saveStudentProgram")
    public ResponseEntity<StandardResponse> registerStudentWithProgram(@RequestBody RequestProgramDto requestProgramDto){

        String message = programService.registerStudentWithProgram(requestProgramDto);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",message), HttpStatus.CREATED);
    }
}
