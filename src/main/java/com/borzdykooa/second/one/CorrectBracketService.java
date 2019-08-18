package com.borzdykooa.second.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Дана строка, содержащая следующие символы: ‘)’, ‘(‘, ‘}’, ‘{’, ‘[’, ‘]’.
 * Задача: определить, является ли переданная строка корректной. Она будет таковой, если:
 * Открывающие скобочки должны быть закрыты закрывающими того же типа.
 * Открывающие скобочки должны быть закрыты в нужном порядке.
 * Пустая строка тоже считается правильной.
 * Пример:
 * () – корректная
 * (){}[] – корректная
 * (] – не корректная
 * ([)] – не корректная
 * {[]} – корректная
 */
public class CorrectBracketService {

    public boolean isStringCorrect(String string) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (isOpeningBracket(current)) {
                deque.add(current);
            }
            if (isClosingBracket(current)) {
                if (deque.isEmpty() || !isPairOfBrackets(current, deque.peekLast())) {
                    return false;
                } else {
                    deque.removeLast();
                }
            }
        }

        return deque.isEmpty();
    }

    private boolean isOpeningBracket(char current) {
        return current == '{' || current == '(' || current == '[';
    }

    private boolean isClosingBracket(char current) {
        return current == '}' || current == ')' || current == ']';
    }

    private boolean isPairOfBrackets(char current, char last) {
        return (current == '}' && last == '{') || (current == ')' && last == '(') || (current == ']' && last == '[');
    }
}
