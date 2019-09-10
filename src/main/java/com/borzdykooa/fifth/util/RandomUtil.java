package com.borzdykooa.fifth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtil {

    public static Random getRandom() {
        return new Random();
    }
}
