package com.borzdykooa.forth.iterator;

import com.borzdykooa.forth.visitor.Visitor;
import com.borzdykooa.third.model.Node;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

@Getter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public abstract class TreeIterator<T extends Comparable<T>> implements Iterator<T> {

    private Deque<Node<T>> deque = new ArrayDeque<>();

    public TreeIterator(Node<T> root) {
        if (root != null) {
            deque.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    public abstract long accept(Visitor visitor);
}
