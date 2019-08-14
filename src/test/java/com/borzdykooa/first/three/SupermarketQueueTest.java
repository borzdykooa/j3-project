package com.borzdykooa.first.three;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class SupermarketQueueTest {

    @Test
    public void getTotalTime1() {
        Queue<Integer> arrayBlockingQueue = new LinkedList<>(Arrays.asList(5, 3, 4));
        Integer totalTime = SupermarketQueue.getTotalTime(1, arrayBlockingQueue);
        assertEquals(12, totalTime.intValue());
    }

    @Test
    public void getTotalTime2() {
        Queue<Integer> arrayBlockingQueue = new LinkedList<>(Arrays.asList(10, 2, 3));
        Integer totalTime = SupermarketQueue.getTotalTime(2, arrayBlockingQueue);
        assertEquals(10, totalTime.intValue());
    }

    @Test
    public void getTotalTime3() {
        Queue<Integer> arrayBlockingQueue = new LinkedList<>(Arrays.asList(2, 3, 10));
        Integer totalTime = SupermarketQueue.getTotalTime(2, arrayBlockingQueue);
        assertEquals(12, totalTime.intValue());
    }
}
