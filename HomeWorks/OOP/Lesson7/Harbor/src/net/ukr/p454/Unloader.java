package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Unloader implements Runnable {
    Ship ship;
    Dock dock;

    public Unloader(Ship ship, Dock dock) {
        this.ship = ship;
        this.dock = dock;
    }

    @Override
    public void run() {
        dock.setShip(ship);
        dock.unloading();
    }
}
