package com.borzdykooa.third.model;

import lombok.Getter;

@Getter
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }
        int result = value.compareTo(current.getValue());
        if (result < 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (result > 0) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }
}
