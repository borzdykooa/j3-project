package com.borzdykooa.forth.iterator;

import com.borzdykooa.forth.strategy.NextStrategy;
import com.borzdykooa.forth.strategy.PreOrderNextStrategy;
import com.borzdykooa.forth.visitor.Visitor;
import com.borzdykooa.third.model.Node;

public class PreOrderTreeIterator<T extends Comparable<T>> extends TreeIterator<T> {

    private NextStrategy nextStrategy = PreOrderNextStrategy.getInstance();

    public PreOrderTreeIterator(Node<T> root) {
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
