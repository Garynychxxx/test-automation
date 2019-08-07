package com.epam.automation.classes.maintask;

import java.util.List;

class HouseArray {
    private List<House> houses;

    HouseArray(List<House> houses) {
        this.houses = houses;

    }

    void printHouseByNumberOfRoom(int numberOfRoom) {
        System.out.printf("\nВывод квартир удовлетворяющих условию: Комнат: %d \n", numberOfRoom);
        for (House house : houses) {
            if (numberOfRoom == house.getNumberOfRoom()) {
                System.out.println(house);
            }
        }
    }

    void printHouseByNumberOfRoomAndRangeOfFloor(int numberOfRoom, int firstValueOfFloorRange, int secondValueOfFloorRange) {
        System.out.printf("\nВывод квартир удовлетворяющих условию: Комнат: %d; Этаж в промежутке от %d до %d \n", numberOfRoom, firstValueOfFloorRange, secondValueOfFloorRange);
        for (House house : houses) {
            if (house.getFloor() >= firstValueOfFloorRange && house.getFloor() <= secondValueOfFloorRange && house.getNumberOfRoom() == numberOfRoom) {
                System.out.println(house);
            }
        }
    }

    void printHouseBySquare(int square) {
        System.out.printf("\nВывод квартир удовлетворяющих условию: Площадь больше: %d \n", square);
        for (House house : houses) {
            if (square < house.getSquare()) {
                System.out.println(house);
            }
        }
    }
}
