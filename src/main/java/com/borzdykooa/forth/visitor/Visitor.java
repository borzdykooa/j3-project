package com.borzdykooa.forth.visitor;

import com.borzdykooa.forth.iterator.TreeIterator;

public interface Visitor {

    <T extends Comparable<T>> long visitTreeIterator(TreeIterator<T> iterator);
}
