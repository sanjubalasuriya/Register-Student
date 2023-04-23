package com.abcinsitute.util.mapper;

import com.abcinsitute.dto.ProgramDto;
import com.abcinsitute.dto.StudentDto;
import com.abcinsitute.model.Program;
import com.abcinsitute.model.Student;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ListMapper {

   List<StudentDto> studentToDtoList(List<Student> students);

   List<StudentDto> studentListToPage(Page<Student> students);

   List<ProgramDto> programListToPage(Page<Program> programs);
}
