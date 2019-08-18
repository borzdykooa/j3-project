package com.borzdykooa.second.four;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача - написать функцию, которая на вход принимает массив целочисленных значений и сортирует его так, что только
 * нечетные значения отсортированы по возрастанию, четные же находятся на тех же местах, что и были.
 * Пример:
 * [5, 3, 2, 8, 1, 4] -> [1, 3, 2, 8, 5, 4]
 */
public class ArraySortService {

    public List<Integer> sortArray(List<Integer> integers) {
        List<Integer> sortedOddNumbers = integers.stream().filter(i -> i % 2 > 0).sorted().collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>(integers.size());
        for (int i = 0, j = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 > 0) {
                newList.add(sortedOddNumbers.get(j));
                j++;
            } else {
                newList.add(integers.get(i));
            }
        }
        return newList;
    }
}
