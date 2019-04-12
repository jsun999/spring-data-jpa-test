package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public Optional<StudentDto> findOne1(String name){
        return studentDao.findOne1( new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name").as(String.class),name);
            }
        });
    }
}
