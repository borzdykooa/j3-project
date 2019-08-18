package com.borzdykooa.second.four;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArraySortServiceTest {

    private ArraySortService arraySortService = new ArraySortService();

    @Test
    public void testSortArray() {
        List<Integer> result = arraySortService.sortArray(Arrays.asList(5, 3, 2, 8, 1, 4));
        assertEquals(Arrays.asList(1, 3, 2, 8, 5, 4), result);
    }
}
