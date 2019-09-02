package com.borzdykooa.third.model;

import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }
}
