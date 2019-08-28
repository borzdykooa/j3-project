package com.borzdykooa.second.one;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CorrectBracketServiceTest {

    private CorrectBracketService correctBracketService = new CorrectBracketService();

    @Test
    public void testIsStringCorrect1() {
        String string = "()";
        assertTrue(correctBracketService.isStringCorrect(string));
    }

    @Test
    public void testIsStringCorrect2() {
        String string = "(){}[]";
        assertTrue(correctBracketService.isStringCorrect(string));
    }

    @Test
    public void testIsStringCorrect3() {
        String string = "(]";
        assertFalse(correctBracketService.isStringCorrect(string));
    }

    @Test
    public void testIsStringCorrect4() {
        String string = "([)]";
        assertFalse(correctBracketService.isStringCorrect(string));
    }

    @Test
    public void testIsStringCorrect5() {
        String string = "{[]}";
        assertTrue(correctBracketService.isStringCorrect(string));
    }

    @Test
    public void testIsStringCorrect6() {
        String string = "";
        assertTrue(correctBracketService.isStringCorrect(string));
    }
}
