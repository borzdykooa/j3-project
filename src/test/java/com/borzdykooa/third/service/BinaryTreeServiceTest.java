package com.borzdykooa.third.service;

import com.borzdykooa.third.model.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeServiceTest {

    private BinaryTreeService<Integer> intBinaryTreeService = new BinaryTreeService<>();
    private BinaryTreeService<Character> charBinaryTreeService = new BinaryTreeService<>();

    private BinaryTree<Integer> intTree;
    private BinaryTree<Character> charTree;

    @Before
    public void init() {
        intTree = new BinaryTree<>();
        intTree.add(8);
        intTree.add(3);
        intTree.add(10);
        intTree.add(1);
        intTree.add(6);
        intTree.add(14);
        intTree.add(4);
        intTree.add(7);
        intTree.add(13);

        charTree = new BinaryTree<>();
        charTree.add('d');
        charTree.add('a');
        charTree.add('e');
        charTree.add('b');
        charTree.add('f');
        charTree.add('c');
        charTree.add('g');
    }

    @Test
    public void firstTask() {
        int totalNumberOfNodes = intBinaryTreeService.getTotalNumberOfNodes(intTree);
        assertEquals(9, totalNumberOfNodes);
    }

    @Test
    public void secondTask() {
        int totalNumberOfNodes = intBinaryTreeService.getMaxDepth(intTree);
        assertEquals(4, totalNumberOfNodes);
    }

    @Test
    public void thirdTaskInOrder() {
        String result = charBinaryTreeService.inOrderConcat(charTree);
        assertEquals("abcdefg", result);
    }

    @Test
    public void thirdTaskPreOrder() {
        String result = charBinaryTreeService.preOrderConcat(charTree);
        assertEquals("dabcefg", result);
    }

    @Test
    public void thirdTaskPostOrder() {
        String result = charBinaryTreeService.postOrderConcat(charTree);
        assertEquals("cbagfed", result);
    }

    @Test
    public void forthTask() {
        String result = charBinaryTreeService.breadthFirstConcat(charTree);
        assertEquals("daebfcg", result);
    }
}
