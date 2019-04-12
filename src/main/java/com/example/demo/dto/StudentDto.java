package com.example.demo.dto;

import com.example.demo.entity.Teacher;

import java.util.Set;

public interface StudentDto {
    Long getId();

    String getName();

    Set<TeacherSummary> getTeachers();

    interface TeacherSummary {
        String getName();
    }

    AddressSummary getAddress();
    interface AddressSummary {
        String getName();
    }
}
