package com.abcinsitute.service;

import com.abcinsitute.dto.ProgramDto;
import com.abcinsitute.dto.StudentDto;
import com.abcinsitute.dto.request.RequestProgramDto;
import com.abcinsitute.paginated.PaginatedResponseProgramDto;
import com.abcinsitute.paginated.PaginatedResponseStudentDto;

public interface ProgramService {

    String saveProgram(ProgramDto programDto);


    String updateProgram(ProgramDto programDto);

    ProgramDto findByProgramId(String programId);

    String deleteProgram(String id);

    PaginatedResponseProgramDto findProgramsByPagination(int page, int size);

    String registerStudentWithProgram(RequestProgramDto requestProgramDto);
}
