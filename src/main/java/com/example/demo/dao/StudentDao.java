package com.example.demo.dao;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    @EntityGraph(attributePaths = { "teachers" })
    StudentDto findMyById(Long id);
}
