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
        if (map.containsKey(student.getCourse())) {
            map.get(student.getCourse()).add(student);
        } else {
            map.put(student.getCourse(), new ArrayList<>(Collections.singletonList(student)));
        }

        return student;
    }

    public List<Student> gexMinCourseStudents() {
        List<Student> minCourseStudents = null;
        if (map != null && !map.isEmpty()) {
            Integer minCourse = map.keySet().stream().sorted().findFirst().get();
            minCourseStudents = map.get(minCourse);
        }

        return minCourseStudents;
    }

    public List<Student> gexMaxCourseStudents() {
        List<Student> maxCourseStudents = null;
        if (map != null && !map.isEmpty()) {
            Integer minCourse = map.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().get();
            maxCourseStudents = map.get(minCourse);
        }

        return maxCourseStudents;
    }
}
