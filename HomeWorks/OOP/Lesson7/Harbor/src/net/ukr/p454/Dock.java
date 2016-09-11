package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Dock {
    private String docName;
    private Ship ship;
    private boolean busy;

    public Dock(String docName, Ship ship) {
        this.docName = docName;
        this.ship = ship;
    }

    public Dock() {
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public synchronized void unloading(){

        Box [] boxes = ship.getBoxes();
        for (int i = 0; i < boxes.length; i++){
            String content = boxes[i].getContent();
            boxes[i] = null;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.docName + " unloaded from the ship " + ship.getName() + " one box with " + content);
        }
        ship.setBoxes(boxes);
    }
}
