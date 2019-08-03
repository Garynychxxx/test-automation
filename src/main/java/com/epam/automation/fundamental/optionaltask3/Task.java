package com.epam.automation.fundamental.optionaltask3;

import java.util.Scanner;

//Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month;

        do {
            System.out.println("Введите число от 1 до 12");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число 1 до 12");
                sc.next();
            }
            month = sc.nextInt();
        } while (!(1<=month && month<=12));
        sc.close();

        String monthString = null;

        switch (month) {
            case 1:  monthString = "Январь";
                break;
            case 2:  monthString = "Февраль";
                break;
            case 3:  monthString = "Март";
                break;
            case 4:  monthString = "Апрель";
                break;
            case 5:  monthString = "Май";
                break;
            case 6:  monthString = "Июнь";
                break;
            case 7:  monthString = "Июль";
                break;
            case 8:  monthString = "Август";
                break;
            case 9:  monthString = "Сентябрь";
                break;
            case 10: monthString = "Октябрь";
                break;
            case 11: monthString = "Ноябрь";
                break;
            case 12: monthString = "Декабрь";
                break;

        }
        System.out.println(monthString);
    }
}

