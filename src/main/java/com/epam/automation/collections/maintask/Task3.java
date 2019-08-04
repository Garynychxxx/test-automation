package com.epam.automation.collections.maintask;

//Реализовать класс, моделирующий работу N-местной автостоянки. Машина подъезжает к определенному месту и едет вправо,
//         пока не встретится свободное место. Класс должен поддерживать методы, обслуживающие приезд и отъезд машины.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Task3 task3 = new Task3();
        task3.takeThePlace();
        task3.takeThePlace();
        task3.takeThePlace();
        task3.takeThePlace();
        task3.takeThePlace();
        task3.leaveThePlace(2);
        task3.takeThePlace();
        task3.takeThePlace();

    }

    public int numberOfFreePlaces;
    static int numberOfPlaces;

    {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите число мест в автостоянке");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            numberOfPlaces = sc.nextInt();
        } while (numberOfPlaces <= 0);
    }

    private Task3() {
        arrayListStation = new ArrayList<>(Collections.nCopies(numberOfPlaces, "Место свободно"));
        numberOfFreePlaces = numberOfPlaces;
    }

    private ArrayList arrayListStation;

    private void takeThePlace() {
        for (int i = 0; i <= arrayListStation.size() - 1; i++) {
            if (this.numberOfFreePlaces > 0) {
                if (arrayListStation.get(i).equals("Место свободно")) {
                    arrayListStation.set(i, "Место занято");
                    this.numberOfFreePlaces--;
                    System.out.println("Вы заняли место № " + (i) +
                            "\n" + arrayListStation.toString());
                    break;
                }

            } else {
                System.out.println("Свободных мест нет, дождитесь выезда машин");
                break;
            }
        }
    }

    private void leaveThePlace(int parkingPlace) {
        arrayListStation.set(parkingPlace, "Место свободно");
        this.numberOfFreePlaces++;
        System.out.println("Вы покинули парковочное место № " + parkingPlace +
                "\n" + arrayListStation.toString());
    }
}
