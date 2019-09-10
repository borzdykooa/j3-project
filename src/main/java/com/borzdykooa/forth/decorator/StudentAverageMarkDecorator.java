package com.borzdykooa.forth.decorator;

import com.borzdykooa.forth.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class StudentAverageMarkDecorator extends TreeIteratorDecorator<Student> {

    private List<Integer> marks = new ArrayList<>();

    public StudentAverageMarkDecorator(Iterator<Student> wrappee) {
        super(wrappee);
    }

    @Override
    public Student next() {
        Student student = super.next();
        marks.addAll(student.getMarks());

        return student;
    }

    public long getAverage() {
        double result = 0;
        if (isNotEmpty(marks)) {
            result = marks.stream().mapToInt(Integer::intValue).average().getAsDouble();
        }

        return Math.round(result);
    }
}
