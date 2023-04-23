package com.abcinsitute.service.impl;

import com.abcinsitute.dto.ProgramDto;

import com.abcinsitute.dto.request.RequestProgramDto;
import com.abcinsitute.exception.DuplicateKeyException;
import com.abcinsitute.exception.NotFoundException;
import com.abcinsitute.model.Program;
import com.abcinsitute.model.Student;
import com.abcinsitute.model.StudentProgram;
import com.abcinsitute.model.StudentProgramId;
import com.abcinsitute.paginated.PaginatedResponseProgramDto;

import com.abcinsitute.repo.ProgramRepo;
import com.abcinsitute.repo.StudentProgramRepo;
import com.abcinsitute.repo.StudentRepo;
import com.abcinsitute.service.ProgramService;
import com.abcinsitute.util.mapper.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepo programRepo;

    @Autowired
    private StudentProgramRepo studentProgramRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @Autowired
    private StudentRepo studentRepo;

    // save

    @Override
    public String saveProgram(ProgramDto programDto) {

        Program program = modelMapper.map(programDto, Program.class);
        if (!programRepo.existsById(program.getProgramId())) {
            programRepo.save(program);
            return program.getProgramId() + " saved successfully";
        } else {
            throw new DuplicateKeyException("Already Added");
        }

    }

    // update

    @Override
    public String updateProgram(ProgramDto programDto) {
        Program program = modelMapper.map(programDto, Program.class);
        if (programRepo.existsById(programDto.getProgramId())) {
            programRepo.save(program);
            return program.getProgramId() + " Updated successfully";
        } else {
            throw new NotFoundException("Student does not exist");
        }
    }

    // find by id

    @Override
    public ProgramDto findByProgramId(String programId) {
        if (programRepo.existsById(programId)) {
            Program program = programRepo.getReferenceById(programId);
            ProgramDto programDto = modelMapper.map(program, ProgramDto.class);
            return programDto;
        } else {
            throw new NotFoundException("No data");
        }
    }

    // delete

    @Override
    public String deleteProgram(String id) {
        if (programRepo.existsById(id)) {
            programRepo.deleteById(id);
            return "Deleted successfully " + id;
        } else {
            throw new NotFoundException("Does not found Student");
        }
    }

    // find all with pagination

    @Override
    public PaginatedResponseProgramDto findProgramsByPagination(int page, int size) {
        Page<Program> programs = programRepo.findAll(PageRequest.of(page, size));

        if (programs.getSize() < 1) {
            throw new NotFoundException("No Data");
        }
        PaginatedResponseProgramDto paginatedResponseProgramDto = new PaginatedResponseProgramDto(
                listMapper.programListToPage(programs),
                (int) programRepo.count()
        );
        return paginatedResponseProgramDto;
    }

    // Register a student with a project

    @Override
    @Transactional
    public String registerStudentWithProgram(RequestProgramDto requestProgramDto) {

        if (studentRepo.existsById(requestProgramDto.getStudentId()) && programRepo.existsById(requestProgramDto.getProgramId())) {

            Student student = studentRepo.getReferenceById(requestProgramDto.getStudentId());
            Program program = programRepo.getReferenceById(requestProgramDto.getProgramId());
            StudentProgram studentProgram = new StudentProgram();
            studentProgram.setId(new StudentProgramId(requestProgramDto.getStudentId(), requestProgramDto.getProgramId()));
            studentProgram.setStudent(student);
            studentProgram.setProgram(program);

            studentProgramRepo.save(studentProgram);

            return "saved student " + student.getStudentId();
        }
        else {
            throw new NotFoundException("Data Not Found");
        }
    }


}
