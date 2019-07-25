package com.epam.automation.fundamental.optionaltask2;

/*Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.*/

import java.util.ArrayList;
import java.util.Scanner;

public class task7 {

    public static void main(String[] args) {

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


        int number;
        ArrayList<Integer> arrayList = new ArrayList<>();

        do {
            System.out.println("Введите число");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести целое число");
                sc.next();
            }
            arrayList.add(sc.nextInt());
            count--;
        } while (count != 0);

        for (Integer integer : arrayList) {
            int[] valueCharArray ;
                }

        }
    }

}
