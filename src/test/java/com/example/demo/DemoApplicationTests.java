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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;
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

    @Test
    public void test_finds2(){
        Long o = studentDao.countStudentTeacherCountById(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Expression> list = new ArrayList<>();
                list.add(criteriaBuilder.count(root.get("teachers")));
                list.add(criteriaBuilder.equal(root.get("name").as(String.class),"jsun2"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        });
        System.out.println(o);
    }

    @Test
    public void test_find3(){
        Optional<Student> s = studentDao.findOne(
            new Specification<Student>() {
                @Override
                public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.equal(root.get("name").as(String.class),"jsun2");
                }
            }

        );
        System.out.println("123123123");
    }

}
