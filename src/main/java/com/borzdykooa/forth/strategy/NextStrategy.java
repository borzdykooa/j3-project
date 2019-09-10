package com.borzdykooa.forth.strategy;

import com.borzdykooa.third.model.Node;

import java.util.Deque;

public interface NextStrategy {

    <T extends Comparable<T>> T next(Deque<Node<T>> deque);
}
