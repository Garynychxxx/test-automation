package com.epam.automation.threads.maintask;

 class Ship {
    int containers;
    String name;


     Ship(String name, int containers) {
        this.name = name;
        this.containers = containers;

    }

     int getContainers() {
        return containers;
    }

     String getName() {
        return name;
    }
}
