package com.epam.automation.collections.optionaltask;

//Не используя вспомогательных объектов, переставить отрицательные.
//        элементы данного списка в конец, а положительные — в начало списка.

import java.util.ArrayList;
import java.util.Random;

public class Task13 {

    public static void main(String[] args) {

        ArrayList<Integer> reportArray = getInitializedArray();
        System.out.println(reportArray);
        System.out.println(getSortByPlusMinusArray(reportArray));

    }

    static ArrayList<Integer> getInitializedArray() {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(31) - 15);
        }
        return arrayList;
    }

    static ArrayList<Integer> getSortByPlusMinusArray(ArrayList<Integer> arrayList) {

        int arraySizeDemfer = 0;
        for (int i = 0; i < arrayList.size() - arraySizeDemfer; i++) {
            if (arrayList.get(i) < 0) {
                arrayList.add(arrayList.get(i));
                arrayList.remove(i);
                arraySizeDemfer++;
                i--;
            }
        }
        return arrayList;
    }
}

