package com.ilyap.tasks;

import java.math.BigInteger;
import java.util.*;

/**
 * Рекурсивный способ может работать долго, потому что в процессе вычисления
 * функция будет много раз вызываться от одного и того же аргумента
 * (например, при вычислении f(5) функция сделает рекурсивные вызовы к f(4) и f(3),
 * оба рекурсивных вызова обратятся к f(2)), что приведёт к
 * многократному повторению одних и тех же операций.
 * Поэтому было принято решение сделать кэш.
 */

public final class Fibonacci {
    private static final Map<Long, BigInteger> cache = new TreeMap<>();

    private Fibonacci() {
    }

    public static BigInteger fib(long n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            BigInteger v = fib(n - 2).add(fib(n - 1));
            cache.put(n, v);
            return v;
        }
    }
}