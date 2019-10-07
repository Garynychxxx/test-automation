package com.epam.automation.threads.maintask;

public class Berth extends Thread {
    Berth(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {

            while (!Port.blockingQueue.isEmpty()) {
                Ship ship = Port.blockingQueue.take();
                System.out.println(ship.getName() + " прибыл на причал " + this.getName());
                Thread.sleep(Math.abs(ship.getContainers()));
                String loadUnload = ship.getContainers() > 0 ? "разгрузку " : "загрузку ";

                System.out.println(ship.getName() + " закончил " + loadUnload + Math.abs(ship.getContainers()) +
                        " контейнеров. В порту " + Port.loading(ship.containers) + " контейнеров.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
