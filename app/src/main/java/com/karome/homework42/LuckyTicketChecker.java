package com.karome.homework42;

public class LuckyTicketChecker {
    public static boolean isLucky(int number) {
        int sumOfEvenDigits = 0;
        int sumOfOddDigits = 0;
        for (int i = 0; i < 6; i++) {
            int digit = number % 10;
            if (i % 2 == 0) {
                sumOfEvenDigits += digit;
            } else {
                sumOfOddDigits += digit;
            }
            number /= 10;
        }
        return sumOfEvenDigits == sumOfOddDigits;
    }
}

