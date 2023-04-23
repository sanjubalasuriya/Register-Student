package com.abcinsitute.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestProgramDto {

    private String programId;
    private String studentId;
}
