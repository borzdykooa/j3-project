package com.borzdykooa.forth.decorator;

import com.borzdykooa.forth.iterator.TreeIterator;
import com.borzdykooa.forth.visitor.Visitor;
import lombok.AllArgsConstructor;

import java.util.Iterator;

@AllArgsConstructor
public abstract class TreeIteratorDecorator<T extends Comparable<T>> extends TreeIterator<T> {

    private Iterator<T> wrappee;

    @Override
    public boolean hasNext() {
        return wrappee.hasNext();
    }

    @Override
    public T next() {
        return wrappee.next();
    }

    @Override
    public long accept(Visitor visitor) {
        return visitor.visitTreeIterator(this);
    }
}
