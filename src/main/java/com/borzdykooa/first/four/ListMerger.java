package com.borzdykooa.first.four;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача - написать функцию, которая принимает два отсортированных от меньшего к большему списка целочисленных значений
 * (ArrayList). Списки могут быть разных размеров. В результате выполнения функции в первом списке должны содержаться
 * элементы обоих списков, также отсортированных от меньшего к большему. Второй же список должен остаться неизменным.
 * <p>
 * Пример:
 * Первый список: [1, 3, 5], второй список: [2, 6, 8].
 * Результат:
 * Первый список: [1, 2, 3, 5, 6, 8], второй список: [2, 6, 8]
 * Сложность алгоритма должна быть O(n).
 * <p>
 * Также желательно реализовать второй вариант задачи, если количество списков может быть любым, а не только два.
 */
@UtilityClass
class ListMerger {

    public static void mergeLists(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>(firstList.size() + secondList.size());
        for (int i = 0, j = 0; i < firstList.size() && j < secondList.size(); ) {
            if (firstList.get(i) < secondList.get(j)) {
                result.add(firstList.get(i));
                i++;
            } else {
                result.add(secondList.get(j));
                j++;
            }
            if (i == firstList.size()) {
                result.addAll(secondList.subList(j, secondList.size()));
            } else if (j == secondList.size()) {
                result.addAll(firstList.subList(i, firstList.size()));
            }
        }
        firstList.clear();
        firstList.addAll(result);
    }
}
