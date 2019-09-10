package com.borzdykooa.forth.iterator;

import com.borzdykooa.forth.strategy.BFSNextStrategy;
import com.borzdykooa.forth.strategy.NextStrategy;
import com.borzdykooa.forth.visitor.Visitor;
import com.borzdykooa.third.model.Node;

public class BFSTreeIterator<T extends Comparable<T>> extends TreeIterator<T> {

    private NextStrategy nextStrategy = BFSNextStrategy.getInstance();

    public BFSTreeIterator(Node<T> root) {
        super(root);
    }

    @Override
    public T next() {
        return nextStrategy.next(super.getDeque());
    }

    @Override
    public long accept(Visitor visitor) {
        return visitor.visitTreeIterator(this);
    }
}
