package com.borzdykooa.second.three;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Доминирующий элемент – это элемент, который появляется в множестве более чем N / 2 (где N – количество элементов в множестве).
 * Задача – написать сервис, который принимает список элементов целочисленных значений, а возвращает доминирующий элемент.
 * Например:
 * [10, 9, 9, 9, 10] – доминирующий элемент 9
 * [3, 2, 3] – доминирующий элемент 3
 * [2, 2, 1, 1, 1, 2, 2] – доминирующий элемент 2
 * <p>
 * Примечание: список элементов обязан иметь доминирующее число. Задачу необходимо решить с использованием необходимых
 * структур данных. Второе решение желательно тоже реализовать, которое позволяет оптимально найти доминирующее число за O(n).
 */
public class DominantElementService {

    public Integer findDominantElement(List<Integer> list) {
        Map<Integer, Long> collect = list
                .stream()
                .collect(Collectors.groupingBy(element -> element, Collectors.counting()));

        return collect.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > list.size() / 2)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }
}
