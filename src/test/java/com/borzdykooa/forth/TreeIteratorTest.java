package com.borzdykooa.forth;

import com.borzdykooa.forth.decorator.StudentAverageMarkDecorator;
import com.borzdykooa.forth.decorator.StudentStatisticDecorator;
import com.borzdykooa.forth.iterator.TreeIterator;
import com.borzdykooa.forth.iterator.BFSTreeIterator;
import com.borzdykooa.forth.iterator.PreOrderTreeIterator;
import com.borzdykooa.forth.model.Student;
import com.borzdykooa.forth.visitor.StudentAverageMarkVisitor;
import com.borzdykooa.third.model.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class TreeIteratorTest {

    private BinaryTree<Character> charTree;
    private BinaryTree<Student> studentTree;

    @Before
    public void init() {
        charTree = new BinaryTree<>();
        charTree.add('d');
        charTree.add('a');
        charTree.add('e');
        charTree.add('b');
        charTree.add('f');
        charTree.add('c');
        charTree.add('g');

        studentTree = new BinaryTree<>();
        studentTree.add(new Student("Kate", 3, Arrays.asList(7, 8, 9, 10)));
        studentTree.add(new Student("Denis", 5, Arrays.asList(10, 10, 10, 10)));
        studentTree.add(new Student("Alex", 2, Arrays.asList(7, 7, 7, 7)));
        studentTree.add(new Student("Ivan", 3, Arrays.asList(7, 8, 6, 6)));
        studentTree.add(new Student("Peter", 4, Arrays.asList(7, 8, 9, 10)));
        studentTree.add(new Student("Olga", 1, Arrays.asList(7, 8, 9, 10)));
        studentTree.add(new Student("Helen", 2, Arrays.asList(9, 9, 9, 10)));
    }

    @Test
    public void testPreOrderIterator() {
        Iterator<Character> iteratorPreOrder = new PreOrderTreeIterator<>(charTree.getRoot());
        StringBuilder stringBuilder = new StringBuilder();
        while (iteratorPreOrder.hasNext()) {
            stringBuilder.append(iteratorPreOrder.next());
        }

        assertEquals("dabcefg", stringBuilder.toString());
    }

    @Test
    public void testBFSIterator() {
        Iterator<Character> iteratorBFS = new BFSTreeIterator<>(charTree.getRoot());
        StringBuilder stringBuilder = new StringBuilder();
        while (iteratorBFS.hasNext()) {
            stringBuilder.append(iteratorBFS.next());
        }

        assertEquals("daebfcg", stringBuilder.toString());
    }

    @Test
    public void testStudentAverageMarkDecorator() {
        Iterator<Student> iteratorBFS = new StudentAverageMarkDecorator(new BFSTreeIterator<>(studentTree.getRoot()));
        while (iteratorBFS.hasNext()) {
            iteratorBFS.next();
        }

        assertEquals(8, ((StudentAverageMarkDecorator) iteratorBFS).getAverage());
    }

    @Test
    public void testStudentStatisticDecorator() {
        Iterator<Student> iteratorPreOrder = new StudentStatisticDecorator(new PreOrderTreeIterator<>(studentTree.getRoot()));
        while (iteratorPreOrder.hasNext()) {
            iteratorPreOrder.next();
        }

        assertEquals(Collections.singletonList(new Student("Olga", 1, Arrays.asList(7, 8, 9, 10))),
                ((StudentStatisticDecorator) iteratorPreOrder).gexMinCourseStudents());
        assertEquals(Collections.singletonList(new Student("Denis", 5, Arrays.asList(10, 10, 10, 10))),
                ((StudentStatisticDecorator) iteratorPreOrder).gexMaxCourseStudents());
    }

    @Test
    public void testStudentAverageMarkVisitor() {
        StudentAverageMarkVisitor visitor = new StudentAverageMarkVisitor();
        TreeIterator<Student> iterator = new PreOrderTreeIterator<>(studentTree.getRoot());
        long result = visitor.getAverageMark(iterator);

        assertEquals(8, result);
    }
}
