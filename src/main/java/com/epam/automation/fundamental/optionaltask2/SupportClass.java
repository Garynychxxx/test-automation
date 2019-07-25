package com.epam.automation.fundamental.optionaltask2;

import java.util.ArrayList;
import java.util.Scanner;

public class SupportClass {
    public static ArrayList<Integer> inputNumbers()

    {
        ArrayList<Integer> arrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int count;

        do {
            System.out.println("Введите необходимое количество чисел");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            count = sc.nextInt();
        } while (count <= 0);

        do {
            System.out.println("Введите число");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести целое число");
                sc.next();
            }
            arrayList.add(sc.nextInt());
            count--;
        } while (count != 0);

        sc.close();
        return arrayList;

    }

}



