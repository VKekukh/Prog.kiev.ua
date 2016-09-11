package net.ukr.p454;


/**
 * Created by Dalvik on 11.09.2016.
 */
public class Harbor {
    String name;
    Dock[] docks = new Dock[0];
    Ship[] ships = new Ship[2];
    boolean portRunning = true;

    public Harbor(String name) {
        this.name = name;
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

    public void unloadShip(){
        int position = 0;
        while (portRunning){
            if(ships[position] != null){
                
            }
            position = ((++position) > ships.length)?0:position;
        }
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
}
