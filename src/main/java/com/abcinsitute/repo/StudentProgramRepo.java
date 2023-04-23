package com.abcinsitute.repo;

import com.abcinsitute.model.StudentProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface StudentProgramRepo extends JpaRepository<StudentProgram, String>{
}
