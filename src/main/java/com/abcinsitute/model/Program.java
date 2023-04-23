package com.abcinsitute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "program")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Program {

    @Id
    @Column(name = "program_id",length = 45)
    private String programId;
    @Column(name = "name",length = 45)
    private String name;
    @Column(name = "duration",length = 45)
    private String duration;
    @Column(name = "cost",length = 45)
    private String cost;

    @OneToMany(mappedBy = "program")
    private Set<StudentProgram> studentPrograms;


}
