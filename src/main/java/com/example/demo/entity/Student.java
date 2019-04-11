package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "jpa_student")
@NamedEntityGraph(name = "Student.lazy", attributeNodes = {@NamedAttributeNode("teachers")})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;


//    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "student_teacher", inverseJoinColumns = @JoinColumn(name = "teacher_id"), joinColumns = @JoinColumn(name = "student_id"))
    private Set<Teacher> teachers = new HashSet<>();

}
