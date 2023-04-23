package com.abcinsitute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentProgramId implements Serializable {

    @Column(name = "student_student_id")
    private String studentId;
    @Column(name = "program_program_id")
    private String programId;
}
