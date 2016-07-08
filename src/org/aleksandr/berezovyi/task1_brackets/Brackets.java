package org.aleksandr.berezovyi.task1_brackets;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by pepsik on 7/7/2016.
 */
public class Brackets {
    public static String sequence = "";
    public static List<String> sequences = new ArrayList<>();

    public static void getSequence(int n, int nClose) {
        if (n == 0) {
            sequences.add(sequence);
            return;
        }
        if (nClose == 0) {
            sequence = sequence + "(";
            getSequence(n - 1, 1);
        }
        if (nClose > 0) {
            if (n > nClose) {
                String temp = sequence;
                sequence = sequence + "(";
                getSequence(n - 1, nClose + 1);
                sequence = temp;
            }
            sequence = sequence + ")";
            getSequence(n - 1, nClose - 1);
        }
    }

    public static void main(String[] args) {
        int N = 3;
        Brackets.getSequence(N * 2, 0);
        Brackets.sequences.forEach(System.out::println);
    }
}
