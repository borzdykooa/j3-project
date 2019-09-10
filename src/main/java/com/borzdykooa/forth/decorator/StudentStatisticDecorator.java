package com.borzdykooa.forth.decorator;

import com.borzdykooa.forth.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StudentStatisticDecorator extends TreeIteratorDecorator<Student> {

    private Map<Integer, List<Student>> map = new HashMap<>();

    public StudentStatisticDecorator(Iterator<Student> wrappee) {
        super(wrappee);
    }

    @Override
    public Student next() {
        Student student = super.next();
        map.merge(student.getCourse(), new ArrayList<>(Collections.singletonList(student)), (oldVal, newVal) -> {
            oldVal.addAll(newVal);
            return new ArrayList<>(oldVal);
        });

        return student;
    }

    public List<Student> gexMinCourseStudents() {
        List<Student> minCourseStudents = null;
        if (map != null && !map.isEmpty()) {
            Integer minCourse = map.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
            minCourseStudents = map.get(minCourse);
        }

        return minCourseStudents;
    }

    public List<Student> gexMaxCourseStudents() {
        List<Student> maxCourseStudents = null;
        if (map != null && !map.isEmpty()) {
            Integer minCourse = map.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
            maxCourseStudents = map.get(minCourse);
        }

        return maxCourseStudents;
    }
}
