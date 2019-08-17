package com.borzdykooa.second.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Анаграммы – это слова, которые состоят из одних и тех же символов, но в разном порядке. Дан массив строк, найти в нем
 * анаграммы и вернуть список групп этих анаграмм. Каждый список отсортирован в алфавитном порядке. Оценить сложность
 * написанного алгоритма.
 * Пример:
 * ["eat", "tea", "tan", "ate", "nat", "bat"]
 * На выходе должны получить:
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Примечание: каждая группа анаграмм тоже должна быть в нужном порядке, т.е. группа ["ate", "eat","tea"] идет первой,
 * потому что слово “eat” было найдено первым в исходном массиве, ["nat","tan"] второй, потому что “tan” было найдено
 * вторым (вообще третьим, но т.к. “tea” вошло в первую группу анаграмм, то считается вторым) и т.д.
 */
public class AnagramService {

    public List<Set<String>> groupAnagrams(String[] input) {
        List<String> strings = Arrays.asList(input);
        List<String> sortedStrings = strings.stream().map(this::sortString).collect(Collectors.toList());
        List<String> uniqueStrings = new ArrayList<>(new LinkedHashSet<>(sortedStrings));

        List<Set<String>> result = new ArrayList<>(uniqueStrings.size());
        for (int i = 0; i < uniqueStrings.size(); i++) {
            result.add(new TreeSet<>());
        }
        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < uniqueStrings.size(); j++) {
                if (sortedStrings.get(i).equals(uniqueStrings.get(j))) {
                    result.get(j).add(strings.get(i));
                    break;
                }
            }
        }
        return result;
    }

    private String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        return String.valueOf(arr);
    }
}
