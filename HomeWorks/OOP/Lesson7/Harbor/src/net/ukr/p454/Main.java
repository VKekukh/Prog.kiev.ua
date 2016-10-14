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

<<<<<<< HEAD
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

=======
        Box boxTwo = new Box("Boards", 10000);
        Box[] boxesTwo = new Box[10];

        for (int i = 0; i < boxesTwo.length; i++) {
            boxesTwo[i] = boxTwo.clone();
        }

        Box boxThree = new Box("Tobacco", 10000);
        Box[] boxesThree = new Box[10];

        for (int i = 0; i < boxesThree.length; i++) {
            boxesThree[i] = boxThree.clone();
        }

        Ship alfa = new Ship("Alfa", boxes);
        Ship beta = new Ship("Beta", boxesTwo);
        Ship gamma = new Ship ("Gamma",boxesThree);

        Dock dockOne = new Dock("DockOne");
        Dock dockTwo = new Dock("DockTwo");

        Dock[] docks = {dockOne, dockTwo};
        Ship[] ships = {alfa, beta};

        Harbor harbor = new Harbor(docks,"Odessa",ships);

>>>>>>> b494a24e7d319cb5850cbf6d9bdc00c7bd45ae1f
    }
}
