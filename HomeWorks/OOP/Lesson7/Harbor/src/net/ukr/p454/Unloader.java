package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Unloader implements Runnable {
<<<<<<< HEAD
    Ship ship;
    Dock dock;
=======
    private Ship ship;
    private Dock dock;
>>>>>>> b494a24e7d319cb5850cbf6d9bdc00c7bd45ae1f

    public Unloader(Ship ship, Dock dock) {
        this.ship = ship;
        this.dock = dock;
    }

    @Override
    public void run() {
<<<<<<< HEAD
        dock.setShip(ship);
        dock.unloading();
=======
        dock.unloading(ship);
>>>>>>> b494a24e7d319cb5850cbf6d9bdc00c7bd45ae1f
    }
}
