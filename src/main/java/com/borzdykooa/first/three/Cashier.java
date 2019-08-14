package com.borzdykooa.first.three;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Queue;
import java.util.concurrent.Callable;

@Getter
@AllArgsConstructor
public class Cashier implements Callable<Integer> {

    private Queue<Integer> queue;

    @Override
    public Integer call() throws InterruptedException {
        Integer commonTime = 0;
        while (!queue.isEmpty()) {
            Integer time = queue.poll();
            commonTime = time + commonTime;
            Thread.sleep((long) time * 1000);
        }
        return commonTime;
    }
}
