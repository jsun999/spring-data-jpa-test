package com.example.demo;

import com.example.demo.dao.SchoolClassDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.SchoolClass;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;
    @Test
    public void test_findById(){
        List all = studentDao.findAll();
        for (int i = 0; i < all.size(); i++) {
            Object o =  all.get(i);

            System.out.println(o);
        }

    }

    @Test
    public void test_findS(){
        StudentDto student = studentDao.findMyById((long) 1);
        Set<StudentDto.TeacherSummary> studentTeachers= student.getTeachers();
        for (Iterator<StudentDto.TeacherSummary> iterator = studentTeachers.iterator(); iterator.hasNext(); ) {
            StudentDto.TeacherSummary next =  iterator.next();
            System.out.println(next.getName());
        }
        System.out.println(student.getAddress().getName());
    }




}
