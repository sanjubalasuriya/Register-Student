package com.abcinsitute.paginated;

import com.abcinsitute.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseStudentDto {

    List<StudentDto> list;
    private long dataCount;

}
