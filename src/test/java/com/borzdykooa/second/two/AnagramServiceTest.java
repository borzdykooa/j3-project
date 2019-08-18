package com.borzdykooa.second.two;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AnagramServiceTest {

    private AnagramService anagramService = new AnagramService();

    @Test
    public void testGroupAnagrams() {
        List<Set<String>> result = anagramService.groupAnagrams(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));

        assertEquals(Arrays.asList("ate", "eat", "tea"), Arrays.asList(result.get(0).toArray(new String[0])));
        assertEquals(Arrays.asList("nat", "tan"), Arrays.asList(result.get(1).toArray(new String[0])));
        assertEquals(Collections.singletonList("bat"), Arrays.asList(result.get(2).toArray(new String[0])));
    }
}
