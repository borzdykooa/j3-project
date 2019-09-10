package com.borzdykooa.forth.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private String name;
    private int course;
    private List<Integer> marks;

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.getName());
    }
}
