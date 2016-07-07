package org.aleksandr.berezovyi.task3_sum;

import java.math.BigInteger;

import static java.math.BigInteger.*;

/**
 * Created by pepsik on 7/7/2016.
 */
public class SumFactorial {
    public static void main(String[] args) {

        BigInteger result = valueOf(1);
        BigInteger sum = valueOf(0);
        for (int i = 2; i < 100; i++) {
            result = result.multiply(valueOf(i));
        }

        while (result.compareTo(valueOf(2)) > 0){
            sum = sum.add(result.remainder(valueOf(10)));
            result = result.divide(valueOf(10));
        }
    }
}
