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

    public synchronized   boolean isBusy() {
        return busy;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public synchronized void unloading(Ship ship) {

        while(busy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busy = true;

<<<<<<< HEAD
        while (busy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busy = true;
        Box [] boxes = ship.getBoxes();
        for (int i = 0; i < boxes.length; i++){
            String content = boxes[i].getContent();
            boxes[i] = null;
=======
        Box[] boxes = ship.getBoxes();
        for (int i = 0; i < boxes.length; i++) {
>>>>>>> b494a24e7d319cb5850cbf6d9bdc00c7bd45ae1f

            try {
                System.out.println("Box with " + boxes[i].getContent() + " was unloaded from ship " + ship.getName() + " in dock " + this.docName);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
<<<<<<< HEAD
        ship.setBoxes(boxes);
=======
        ship.setBoxes(null);
>>>>>>> b494a24e7d319cb5850cbf6d9bdc00c7bd45ae1f
        busy = false;
        notifyAll();
    }
}
