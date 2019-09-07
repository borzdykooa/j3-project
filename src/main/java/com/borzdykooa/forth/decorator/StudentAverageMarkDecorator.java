package com.borzdykooa.forth.decorator;

import com.borzdykooa.forth.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentAverageMarkDecorator extends TreeIteratorDecorator<Student> {

    private List<Integer> list = new ArrayList<>();

    public StudentAverageMarkDecorator(Iterator<Student> wrappee) {
        super(wrappee);
    }

    @Override
    public Student next() {
        Student student = super.next();
        list.addAll(student.getMarks());

        return student;
    }

    public long getAverage() {
        double result = 0;
        if (list != null && !list.isEmpty()) {
            result = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        }

        return Math.round(result);
    }
}
