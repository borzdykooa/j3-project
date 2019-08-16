package com.borzdykooa.first.three;

import com.borzdykooa.general.ApplicationException;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * В супермаркете есть определенное количество касс для обслуживания покупателей. У каждого покупателя есть корзина
 * товаров. Кассир затрачивает ровно 1 секунду для того, чтобы пробить каждый товар в корзине. Следовательно, если в
 * корзине покупателя 10 товаров, то кассир сможет обслужить его ровно за 10 секунд.
 * <p>
 * Задача - написать сервис, который возвращает общее время в секундах, которое было затрачено кассирами для
 * обслуживания всех покупателей.
 * <p>
 * Пример:
 * 1. 1 касса и 3 покупателя (5, 3 и 4 товара у каждого соответственно) -> будет затрачено 12 секунд.
 * 2. 2 кассы и 4 покупателя (10, 2, 3 и 3 товара у каждого соответственно) -> будет затрачено 10 секунд (первый
 * покупатель займет кассу на 10 секунд, из-за чего 3 оставшихся успеют купить товары во второй кассе).
 * 3. 2 кассы и 3 покупателя (2, 3 и 10 товар у каждого соответственно) -> будет затрачено 12 секунд.
 * <p>
 * Принимать во внимание, что покупатели будут обслуживаться ровно в том порядке, в котором они идут в списке.
 * Для решения воспользоваться классами из  пакета java.util.concurrent.
 */
@UtilityClass
public class SupermarketQueue {

    public static Integer getTotalTime(Integer numberOfCustomers, List<Integer> customers) {
        Queue<Integer> threadSafeQueue = new ConcurrentLinkedQueue<>(customers);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCustomers);
        List<Cashier> cashiers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            cashiers.add(new Cashier(threadSafeQueue));
        }
        int totalTime = 0;
        try {
            List<Future<Integer>> commonTimes = executorService.invokeAll(cashiers);
            for (Future<Integer> commonTime : commonTimes) {
                Integer time = commonTime.get();
                totalTime = totalTime > time ? totalTime : time;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApplicationException("InterruptedException occurred in SupermarketQueue::getTotalTime");
        } catch (ExecutionException e) {
            throw new ApplicationException("ExecutionException occurred in SupermarketQueue::getTotalTime");
        }
        executorService.shutdown();

        return totalTime;
    }
}
