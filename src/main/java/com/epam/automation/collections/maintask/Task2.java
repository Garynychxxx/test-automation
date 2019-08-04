package com.epam.automation.collections.maintask;

//Задан список целых чисел и некоторое число Y. Не используя вспомогательных объектов и методов сортировки
//        и не изменяя размера списка, переставить элементы списка так, чтобы сначала шли числа, не превосходящие Y,
//        а затем числа, больше Y.

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queueLength;

        System.out.println("Введите Y - число, которое является границей в списке.");
        while (!sc.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            sc.next();
        }
        queueLength = sc.nextInt();

        System.out.println(getChangedArray(getInitializedArray(), queueLength));
    }


    static ArrayList<Integer> getInitializedArray() {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            arrayList.add(random.nextInt(31) - 15);
        }
        System.out.println(arrayList);
        return arrayList;
    }

    static ArrayList<Integer> getChangedArray(ArrayList<Integer> arrayList, int queueLength) {

        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) >= queueLength) {
                for (int j = arrayList.size() - 1; j >= i; j--) {
                    if (arrayList.get(j) < queueLength) {
                        int buffer = arrayList.get(i);
                        arrayList.set(i, arrayList.get(j));
                        arrayList.set(j, buffer);
                    }
                }
            }
        }
        return arrayList;
    }
}
