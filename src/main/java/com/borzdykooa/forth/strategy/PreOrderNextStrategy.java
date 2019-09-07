package com.borzdykooa.forth.strategy;

import com.borzdykooa.third.model.Node;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Deque;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PreOrderNextStrategy implements NextStrategy {

    private static final NextStrategy INSTANCE = new PreOrderNextStrategy();

    @Override
    public <T extends Comparable<T>> T next(Deque<Node<T>> deque) {
        Node<T> node = deque.pop();
        if (node.getRight() != null) {
            deque.push(node.getRight());
        }
        if (node.getLeft() != null) {
            deque.push(node.getLeft());
        }

        return node.getValue();
    }

    public static NextStrategy getInstance() {
        return INSTANCE;
    }
}
