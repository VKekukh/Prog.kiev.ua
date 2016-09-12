package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Dock {
    private String docName;
    private boolean busy;

    public Dock(String docName) {
        this.docName = docName;
    }

    public Dock() {
    }

    public String getDocName() {
        return docName;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public synchronized void unloading(Ship ship) {
        busy = true;
        Box[] boxes = ship.getBoxes();
        for (int i = 0; i < boxes.length; i++) {

            try {
                System.out.println("Box with " + boxes[i].getContent() + " was unloaded from ship " + ship.getName() + " in dock " + this.docName);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = false;
        ship.setBoxes(null);
    }
}
