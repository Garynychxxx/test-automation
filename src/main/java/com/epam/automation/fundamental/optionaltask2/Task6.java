package com.epam.automation.fundamental.optionaltask2;

import java.util.ArrayList;

//Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

public class Task6 {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(SupportClass.inputNumbers());

        boolean stop = false;

        for (Integer integer : arrayList) {
            if (stop){
                break;
            }
            int integerLength = integer.toString().length();
            if (integerLength > 1) {

                for (int i = integerLength-1 ; i >=1; i--) {
                    int firstDigit = (int) (integer / Math.pow(10, i ) % 10);
                    int secondDigit = (int) (integer / Math.pow(10, i -1) % 10);

                    if (secondDigit - firstDigit == 1 && i==1) {
                        System.out.println(integer);
                        stop=true;
                    }
                }
            }
        }
    }
}


