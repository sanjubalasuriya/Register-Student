package com.abcinsitute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramDto {

    private String programId;
    private String name;
    private String duration;
    private String cost;
}
