package com.borzdykooa.forth.strategy;

import com.borzdykooa.third.model.Node;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Deque;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BFSNextStrategy implements NextStrategy {

    private static final NextStrategy INSTANCE = new BFSNextStrategy();

    @Override
    public <T extends Comparable<T>> T next(Deque<Node<T>> deque) {
        Node<T> node = deque.remove();
        T value = node.getValue();
        if (node.getLeft() != null) {
            deque.add(node.getLeft());
        }
        if (node.getRight() != null) {
            deque.add(node.getRight());
        }

        return value;
    }

    public static NextStrategy getInstance() {
        return INSTANCE;
    }
}
