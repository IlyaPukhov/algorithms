package com.ilyap.factorial;

import java.math.BigInteger;

public final class Factorial {
    private Factorial() {}

    public static BigInteger getFactorial(long n) {
        BigInteger fact = BigInteger.ONE;
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else {
            for (int i = 2; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            return fact;
        }
    }
}
