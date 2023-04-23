package com.abcinsitute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_has_program")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentProgram  {


    @EmbeddedId
    private StudentProgramId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_student_id")
    private Student student;

    @ManyToOne
    @MapsId("programId")
    @JoinColumn(name = "program_program_id")
    private Program program;

    @Column(name = "register_date")
    private Date created_At;

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }


}
