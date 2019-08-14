package com.borzdykooa.first.one;

import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Написать функцию, которая принимает список из 10 целочисленных значений (от 0 до 9) и возвращает строковое
 * представление номера в виде: (123) 456-7890.
 * <p>
 * Решить задачу двумя способами, один из которых должен иметь решение с помощью регулярных выражений.
 */
@UtilityClass
public class TelephoneNumberFormatter {

    public static String formatNumber(List<Integer> numbers) {
        return new StringBuilder()
                .append("(")
                .append(appendSublist(numbers.subList(0, 3)))
                .append(") ")
                .append(appendSublist(numbers.subList(3, 6)))
                .append("-")
                .append(appendSublist(numbers.subList(6, 10)))
                .toString();
    }

    public static String formatNumberWithRegex(List<Integer> integers) {
        StringBuilder stringBuilder = new StringBuilder();
        integers.forEach(stringBuilder::append);

        return stringBuilder.toString().replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
    }

    private StringBuilder appendSublist(List<Integer> sublist) {
        StringBuilder stringBuilder = new StringBuilder();
        sublist.forEach(stringBuilder::append);

        return stringBuilder;
    }
}
