package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Ship {
    private String name;
    private Box[] boxes;

    public Ship(String name, Box[] boxes) {
        this.name = name;
        this.boxes = boxes;
    }

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public void setBoxes(Box[] boxes) {
        this.boxes = boxes;
    }

    @Override
    public String toString() {
        StringBuilder builder  = new StringBuilder();
        builder.append("Ship " + name + " has " + boxes.length + " boxes:" + System.lineSeparator());
        for (int i = 1; i <= boxes.length; i++) {
            builder.append(i + ":" + boxes[i-1].toString());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
