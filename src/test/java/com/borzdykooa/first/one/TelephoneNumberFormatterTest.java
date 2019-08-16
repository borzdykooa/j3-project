package com.borzdykooa.first.one;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TelephoneNumberFormatterTest {

    private List<Integer> numbers;

    @Before
    public void init() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    }

    @Test
    public void checkFormatNumber() {
        String formattedNumber = TelephoneNumberFormatter.formatNumber(numbers);
        assertEquals("(123) 456-7890", formattedNumber);
    }

    @Test
    public void checkFormatNumberWithRegex() {
        String formattedNumber = TelephoneNumberFormatter.formatNumberWithRegex(numbers);
        assertEquals("(123) 456-7890", formattedNumber);
    }
}
