package com.borzdykooa.first.two;

import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Выходит премьера фильма “Мстители”. Множество людей стоят в очереди в кассу для покупки билетов. Каждый из
 * покупателей может иметь в кармане следующие купюры: 100$, 50$ или 25$. Сам же билет стоит ровно 25$.
 * <p>
 * Вася работает клерком в кинотеатре и продает каждому покупателю по очереди ровно один билет на фильм “Мстители”.
 * <p>
 * Может ли Вася продать билет каждому покупателю и дать ему сдачу, если изначально у него нет денег в кассе?
 * Принимать во внимание, что билеты продаются строго по очереди.
 * <p>
 * <p>
 * Задача - написать функцию, которая принимает список покупателей, у которых есть в кармане ровно одна из трех
 * возможных купюр, клерка и возвращает true - если клерк Вася может всем выдать сдачу и продать билет, false - иначе.
 * <p>
 * Пример:
 * 25$, 25$, 50$ - true
 * 25$, 100$ - false
 */
@UtilityClass
public class Clerk {

    public static boolean isSuccessfulSale(List<BankNote> bankNotes) {
        int twentyFive = 0;
        int fifty = 0;
        for (BankNote bankNote : bankNotes) {
            switch (bankNote) {
                case TWENTY_FIVE:
                    twentyFive++;
                    break;
                case FIFTY:
                    if (twentyFive > 0) {
                        twentyFive--;
                        fifty++;
                        break;
                    } else {
                        return false;
                    }
                case HUNDRED:
                    if (fifty > 0 && twentyFive > 0) {
                        twentyFive--;
                        fifty--;
                        break;
                    } else if (twentyFive >= 3) {
                        twentyFive = twentyFive - 3;
                        break;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        return true;
    }
}
