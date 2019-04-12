package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class StudentController {
    @Autowired
    StudentDao studentDao;
    @GetMapping("/getstudent/{id}")
    public StudentDto getstudent(@PathVariable("id")Long id){
        return studentDao.findMyById(id);
    }
}
