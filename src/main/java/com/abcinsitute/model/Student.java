package com.abcinsitute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student  {

    @Id
    @Column(name = "studentId",length = 45)
    private String studentId;
    @Column(name = "name",length = 45)
    private String name;
    @Column(name = "address",length = 255)
    private String address;
    @Column(name = "contact",length = 45)
    private String contact;

    @OneToMany(mappedBy = "student")
    private Set<StudentProgram> studentPrograms;




}
