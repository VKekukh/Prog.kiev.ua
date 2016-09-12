package net.ukr.p454;


/**
 * Created by Dalvik on 11.09.2016.
 */
public class Harbor implements Runnable{
    String name;
    Dock[] docks = new Dock[2];
    Ship[] ships = new Ship[0];

    Thread thread;

    public Harbor(String name) {
        this.name = name;
    }

    public Harbor(Dock[] docks, String name, Ship[] ships) {
        this.docks = docks;
        this.name = name;
        this.ships = ships;
        thread = new Thread(this,"Run Harbor");
        thread.start();
    }

    public Harbor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addShip(Ship ship) {
        int position = getFreePosition();

        if (position==-1){
            increaseShipArray();
            ships[ships.length - 1] = ship;
        }
    }

    public void addDock(Dock dock){
        for (int i = 0; i < docks.length; i++) {
            if (docks[i] == null){
                docks[i] = dock;
            }else {
                System.err.println("Port has all docks");
            }
        }
    }

    private synchronized int getFreeDock(){
        int position = -1;

        for (int i = 0; i < docks.length; i++) {
            if(docks[i].isBusy()){
                try {
                    docks[i].wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else
            {
                position = i;
            }
        }
        return  position;
    }

    private void increaseShipArray() {
        Ship[] newArray = new Ship[ships.length + 1];
        System.arraycopy(this.ships, 0, newArray, 0, ships.length);
        this.ships = newArray;
    }

    private int getFreePosition() {
        int position = -1;
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public void run() {
            for (int i = 0; i < ships.length; i++) {
                if (ships[i].getAmountOfBoxes() != 0) {
                    Thread thr= new Thread(new Unloader(ships[i], docks[getFreeDock()]));
                    thr.start();
                }
            }
    }
}
