package com.borzdykooa.second.four;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArraySortServiceTest {

    private ArraySortService arraySortService = new ArraySortService();

    @Test
    public void testSortArray() {
        Integer[] input = {5, 3, 2, 8, 1, 4};
        Integer[] sortedArray = arraySortService.sortArray(input);
        assertEquals(Arrays.asList(1, 3, 2, 8, 5, 4), Arrays.asList(sortedArray));
    }
}
