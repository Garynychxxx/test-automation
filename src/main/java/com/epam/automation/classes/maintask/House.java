package com.epam.automation.classes.maintask;

//House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания,
//            Срок эксплуатации.
//        Создать массив объектов. Вывести:
//        a) список квартир, имеющих заданное число комнат;
//        b) список квартир, имеющих заданное число комнат и расположенных на этаже,
//            который находится в заданном промежутке;
//        c) список квартир, имеющих площадь, превосходящую заданную.

public class House {
    private int id;
    private int flatNumber;
    private int square;
    private int floor;
    private int numberOfRoom;
    private String street;
    private String buildingType;
    private int lifetime;

    House(int id, int flatNumber, int square, int floor, int numberOfRoom, String street, String buildingType, int lifetime) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.square = square;
        this.floor = floor;
        this.numberOfRoom = numberOfRoom;
        this.street = street;
        this.buildingType = buildingType;
        this.lifetime = lifetime;
    }

    int getSquare() {
        return square;
    }

    int getFloor() {
        return floor;
    }

    int getNumberOfRoom() {
        return numberOfRoom;
    }

    @Override
    public String toString() {

        return String.format("id: %-3d номер квартиры: %-3d площадь: %-5d этаж: %-2d количество комнат: %-3d улица: %-15s тип здания: %-21s срок эксплуотации: %-2d лет",id,flatNumber,square,floor,numberOfRoom,street,buildingType,lifetime);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

