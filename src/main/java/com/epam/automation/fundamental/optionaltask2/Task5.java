package com.epam.automation.fundamental.optionaltask2;

import java.util.ArrayList;

//Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

public class Task5 {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(SupportClass.inputNumbers());
        int countOfEvenInList = 0;
        int countOfEvenEqualsUneven = 0;

        for (Integer integer : arrayList) {
            int integerLength = integer.toString().length();

            int countOfEvenOnNumber = 0;
            int countOfUnevenOnNumber = 0;

            for (int i = integerLength - 1; i >= 0; i--) {
                int digit = (int) (integer / Math.pow(10, i) % 10);
                if (digit != 0) {
                    if (digit % 2 == 0) {
                        countOfEvenOnNumber++;

                    } else countOfUnevenOnNumber++;
                    if (i == 0 && countOfEvenOnNumber == integerLength) {
                        countOfEvenInList++;
                    }
                    if (i == 0 && countOfEvenOnNumber == countOfUnevenOnNumber) {
                        countOfEvenEqualsUneven++;
                    }
                }
            }
        }
        System.out.println("Количество чисел содержащих только чётные цифры: " + countOfEvenInList);
        System.out.println("Количество чисел с равным количеством чётных и нечётных цифр: " + countOfEvenEqualsUneven);
    }
}

