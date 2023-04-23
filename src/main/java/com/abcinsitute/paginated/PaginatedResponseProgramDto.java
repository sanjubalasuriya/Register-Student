package com.abcinsitute.paginated;

import com.abcinsitute.dto.ProgramDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseProgramDto {

    List<ProgramDto> list;
    private long dataCount;
}
