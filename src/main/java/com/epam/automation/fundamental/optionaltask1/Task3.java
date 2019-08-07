package com.epam.automation.fundamental.optionaltask1;

import java.util.Scanner;

//Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

public class Task3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count;

        do {
            System.out.println("Введите необходимое количество случайных чисел");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            count = sc.nextInt();
        } while (count <= 0);


        boolean repit = true;
        boolean isLN = false;
        String choice;

        while (repit) {
            System.out.println();
            choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "да":
                    isLN = true;
                    repit = false;
                    break;

                case "нет":
                    isLN = false;
                    repit = false;
                    break;

                default:
                    System.out.println("Каддое с новой строки?\nНужно ввсести \"Да\" или \"Нет\" ");
                    repit = true;
            }

        }
        for (int i = 0; i < count; i++) {
            System.out.print((int) (Math.random() * 1000) + " ");
            if (isLN) {
                System.out.println();
            }

        }

        sc.close();

    }

}