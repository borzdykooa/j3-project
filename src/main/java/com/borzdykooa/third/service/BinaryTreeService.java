package com.borzdykooa.third.service;

import com.borzdykooa.third.model.BinaryTree;
import com.borzdykooa.third.model.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeService<T extends Comparable<T>> {

    public int getTotalNumberOfNodes(BinaryTree<T> tree) {
        Integer count = 0;

        return getCount(tree.getRoot(), count);
    }

    public int getMaxDepth(BinaryTree<T> tree) {
        return maxDepth(tree.getRoot());
    }

    public String inOrderConcat(BinaryTree<T> tree) {
        StringBuilder stringBuilder = new StringBuilder();

        return inOrderDepthSearch(tree.getRoot(), stringBuilder);
    }

    public String preOrderConcat(BinaryTree<T> tree) {
        StringBuilder stringBuilder = new StringBuilder();

        return preOrderDepthSearch(tree.getRoot(), stringBuilder);
    }

    public String postOrderConcat(BinaryTree<T> tree) {
        StringBuilder stringBuilder = new StringBuilder();

        return postOrderDepthSearch(tree.getRoot(), stringBuilder);
    }

    public String breadthFirstConcat(BinaryTree<T> tree) {
        StringBuilder stringBuilder = new StringBuilder();

        return breadthFirstSearch(tree.getRoot(), stringBuilder);
    }

    private Integer getCount(Node<T> node, Integer count) {
        if (node != null) {
            count++;
            count = getCount(node.getLeft(), count);
            count = getCount(node.getRight(), count);
        }
        return count;
    }

    private String inOrderDepthSearch(Node<T> node, StringBuilder stringBuilder) {
        if (node != null) {
            inOrderDepthSearch(node.getLeft(), stringBuilder);
            stringBuilder.append(node.getValue());
            inOrderDepthSearch(node.getRight(), stringBuilder);
        }
        return stringBuilder.toString();
    }

    private String preOrderDepthSearch(Node<T> node, StringBuilder stringBuilder) {
        if (node != null) {
            stringBuilder.append(node.getValue());
            preOrderDepthSearch(node.getLeft(), stringBuilder);
            preOrderDepthSearch(node.getRight(), stringBuilder);
        }
        return stringBuilder.toString();
    }

    private String postOrderDepthSearch(Node<T> node, StringBuilder stringBuilder) {
        if (node != null) {
            postOrderDepthSearch(node.getLeft(), stringBuilder);
            postOrderDepthSearch(node.getRight(), stringBuilder);
            stringBuilder.append(node.getValue());
        }
        return stringBuilder.toString();
    }

    private String breadthFirstSearch(Node<T> root, StringBuilder stringBuilder) {
        if (root != null) {
            Queue<Node<T>> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                Node<T> node = nodes.remove();
                stringBuilder.append(node.getValue());
                if (node.getLeft() != null) {
                    nodes.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nodes.add(node.getRight());
                }
            }
        }
        return stringBuilder.toString();
    }

    private int maxDepth(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(node.getLeft());
            int rightDepth = maxDepth(node.getRight());

            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }
}
