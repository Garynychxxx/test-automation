package com.epam.automation.classes.maintask;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static List<House> houses = new ArrayList<>();

    public static void main(String[] args) {
        houses.add(new House(1, 87, 82, 5, 3, "Машерова 15", "Многоквартирный дом", 20));
        houses.add(new House(2, 3, 67, 1, 3, "Гастелло 14", "Многоквартирный дом", 35));
        houses.add(new House(3, 26, 50, 6, 2, "Горького 123", "Многоквартирный дом", 20));
        houses.add(new House(4, 1, 120, 1, 5, "Фрунзе 100", "Часный дом", 50));
        houses.add(new House(5, 1, 150, 2, 7, "Тавлая 75", "Часный дом", 75));
        houses.add(new House(6, 1, 2, 1, 1, "Лесозоводская 14", "Шалаш", 1));

        HouseArray houseArray = new HouseArray(houses);

        int selectedNumberOfRoom = 3;
        int selectedMinRangeOfFloor = 2;
        int selectedMaxRangeOfFloor = 5;
        int selectedSquare = 50;

        houseArray.printHouseByNumberOfRoom(selectedNumberOfRoom);
        houseArray.printHouseByNumberOfRoomAndRangeOfFloor(selectedNumberOfRoom, selectedMinRangeOfFloor, selectedMaxRangeOfFloor);
        houseArray.printHouseBySquare(selectedSquare);
    }
}
