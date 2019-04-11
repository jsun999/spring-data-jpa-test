package com.example.demo;

import com.example.demo.dao.SchoolClassDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.SchoolClass;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StudentDao studentDao;
//    @Autowired
//    SchoolClassDao schoolClassDao;

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
        Optional<Student> student = studentDao.findMyById((long) 1);
        Student s = student.get();
        System.out.println(s);
    }


    @Test
    public void test1(){
        Optional<Teacher> teacher = teacherDao.findById(1l);
        Teacher t = teacher.get();
        System.out.println(t);
    }

}
