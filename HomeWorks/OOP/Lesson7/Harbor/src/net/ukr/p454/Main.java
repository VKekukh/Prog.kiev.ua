package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        Box box = new Box("Monitors", 10000);
        Box[] boxes = new Box[10];

        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = box.clone();
        }

        Ship alfa = new Ship("ALFA", boxes);

        Dock dockOne = new Dock("DockOne",alfa);
        dockOne.unloading();
    }
}
