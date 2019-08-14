package com.borzdykooa.first.four;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListMergerTest {

    private List<Integer> firstList;
    private List<Integer> secondList;
    private List<Integer> thirdList;

    @Before
    public void init() {
        firstList = new ArrayList<>(Arrays.asList(1, 3, 5));
        secondList = new ArrayList<>(Arrays.asList(2, 6, 8));
        thirdList = new ArrayList<>(Arrays.asList(3, 4, 4, 4));
    }

    @Test
    public void checkMergeLists() {
        ListMerger.mergeLists(firstList, secondList);
        assertEquals(Arrays.asList(1, 2, 3, 5, 6, 8), firstList);
        assertEquals(Arrays.asList(2, 6, 8), secondList);
    }

    @Test
    public void checkMergeLists2() {
        ListMerger.mergeLists(secondList, firstList);
        assertEquals(Arrays.asList(1, 2, 3, 5, 6, 8), secondList);
        assertEquals(Arrays.asList(1, 3, 5), firstList);
    }

    @Test
    public void checkMergeLists3() {
        ListMerger.mergeLists(firstList, thirdList);
        assertEquals(Arrays.asList(1, 3, 3, 4, 4, 4, 5), firstList);
        assertEquals(Arrays.asList(3, 4, 4, 4), thirdList);
    }
}
