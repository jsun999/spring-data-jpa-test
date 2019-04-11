package com.example.demo.dao;

import com.example.demo.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchoolClassDao extends JpaRepository<SchoolClass,Long>, JpaSpecificationExecutor<SchoolClass> {

}
