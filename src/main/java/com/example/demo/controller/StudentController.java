package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.dao.StudentDao;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class StudentController {
    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentService studentService;
    @GetMapping("/getstudent/{id}")
    public StudentDto getstudent(@PathVariable("id")Long id){
        return studentDao.findMyById(id);
    }

    @GetMapping("/getstudentbyname/{name}")
    public StudentDto getstudent(@PathVariable("name")String name){
        return studentService.findOne1(name).get();
    }
}
