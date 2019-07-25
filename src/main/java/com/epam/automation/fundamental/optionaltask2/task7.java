package com.epam.automation.fundamental.optionaltask2;

/*Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class task7 {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(SupportClass.inputNumbers());

        for (Integer integer : arrayList) {
            int integerLength = integer.toString().length();
            if (integerLength > 1) {
                Set<Integer> set = new HashSet<>();


                for (int i = 1; i < integerLength + 1; i++) {
                    int digit = (int) ((integer % Math.pow(10, i)) / Math.pow(10, i - 1));
                    set.add(digit);
                }
                if (set.size() == integerLength) {
                    System.out.println(integer);
                    break;
                }

            }

        }

    }

}
