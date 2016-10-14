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

        Box boxTwo = new Box("Keyboards", 10000);
        Box[] boxesTwo = new Box[10];

        for (int i = 0; i < boxesTwo.length; i++) {
            boxes[i] = boxTwo.clone();
        }


        Ship alfa = new Ship("ALFA", boxes);
        Ship beta = new Ship("Betta", boxesTwo);

        Dock dockOne = new Dock("DockOne",alfa);
        Thread thread = new Thread(new Unloader(alfa,dockOne));
        Thread threadTwo = new Thread(new Unloader(beta,dockOne));

        thread.start();
        threadTwo.start();

    }
}
