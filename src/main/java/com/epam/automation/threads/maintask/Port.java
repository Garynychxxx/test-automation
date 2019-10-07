package com.epam.automation.threads.maintask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Port {

    static BlockingQueue<Ship> blockingQueue;
    static int totalContainersInPort = 5000;

    public static void main(String[] args) {
        blockingQueue = new ArrayBlockingQueue<>(10);

        blockingQueue.add(new Ship("Корабль1", 2010));
        blockingQueue.add(new Ship("Корабль2", -2020));
        blockingQueue.add(new Ship("Корабль3", 3030));
        blockingQueue.add(new Ship("Корабль4", 5040));
        blockingQueue.add(new Ship("Корабль5", 1050));
        blockingQueue.add(new Ship("Корабль6", 4090));
        blockingQueue.add(new Ship("Корабль7", -2010));
        blockingQueue.add(new Ship("Корабль8", 2020));
        blockingQueue.add(new Ship("Корабль9", -3030));
        blockingQueue.add(new Ship("Корабль10", 5040));

        new Berth("Причал 1").start();
        new Berth("Причал 2").start();
        new Berth("Причал 3").start();
        new Berth("Причал 4").start();

    }

    static synchronized int loading(int containers) {
        return (totalContainersInPort += containers);
    }
}
