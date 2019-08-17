package com.borzdykooa.second.one;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        StringBuffer startBuffer = new StringBuffer(string);
        Pattern pattern = Pattern.compile("(\\(\\))|(\\{})|(\\[])");
        Matcher matcher = pattern.matcher(startBuffer);
        while (matcher.find()) {
            matcher.reset();
            StringBuffer endBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(endBuffer, "");
            }
            matcher.appendTail(endBuffer);
            startBuffer = endBuffer;
            matcher = pattern.matcher(startBuffer);
        }

        return startBuffer.length() == 0;
    }
}
