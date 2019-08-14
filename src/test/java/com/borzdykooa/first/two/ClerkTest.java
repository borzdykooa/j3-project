package com.borzdykooa.first.two;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.borzdykooa.first.two.BankNote.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClerkTest {

    private List<BankNote> bankNotes;

    @Test
    public void checkIsSuccessfulSaleTrue() {
        bankNotes = new ArrayList<>(Arrays.asList(TWENTY_FIVE, TWENTY_FIVE, FIFTY));
        boolean result = Clerk.isSuccessfulSale(bankNotes);
        assertTrue(result);
    }

    @Test
    public void checkIsSuccessfulSaleFalse() {
        bankNotes = new ArrayList<>(Arrays.asList(TWENTY_FIVE, HUNDRED));
        boolean result = Clerk.isSuccessfulSale(bankNotes);
        assertFalse(result);
    }
}
