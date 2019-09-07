package com.borzdykooa.forth.visitor;

import com.borzdykooa.forth.iterator.TreeIterator;
import com.borzdykooa.forth.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAverageMarkVisitor implements Visitor {

    public long getAverageMark(TreeIterator<Student> iterator) {
        return iterator.accept(this);
    }

    @Override
    public <T extends Comparable<T>> long visitTreeIterator(TreeIterator<T> iterator) {
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T node = iterator.next();
            if (node instanceof Student) {
                list.addAll(((Student) node).getMarks());
            }
        }
        double result = 0;
        if (!list.isEmpty()) {
            result = list.stream().mapToInt(i -> i).average().getAsDouble();
        }

        return Math.round(result);
    }
}
