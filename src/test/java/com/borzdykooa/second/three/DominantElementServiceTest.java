package com.borzdykooa.second.three;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DominantElementServiceTest {

    private DominantElementService dominantElementService = new DominantElementService();

    @Test
    public void testFindDominantElement1() {
        Integer dominantElement = dominantElementService.findDominantElement(Arrays.asList(10, 9, 9, 9, 10));
        assertEquals(9, dominantElement.intValue());
    }

    @Test
    public void testFindDominantElement2() {
        Integer dominantElement = dominantElementService.findDominantElement(Arrays.asList(3, 2, 3));
        assertEquals(3, dominantElement.intValue());
    }

    @Test
    public void testFindDominantElement3() {
        Integer dominantElement = dominantElementService.findDominantElement(Arrays.asList(2, 2, 1, 1, 1, 2, 2));
        assertEquals(2, dominantElement.intValue());
    }
}
