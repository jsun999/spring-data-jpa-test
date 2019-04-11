package com.example.demo.dao;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

public interface TeacherDao extends JpaRepository<Teacher,Long>, JpaSpecificationExecutor<Teacher> {
    @Modifying
    void deleteByIdAndName(Long id,String name);
}
