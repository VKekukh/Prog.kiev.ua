package net.ukr.p454;

/**
 * Created by Dalvik on 17.10.2016.
 */
public class Hairstyle {
    @SaveFields
    private int length;
    @SaveFields
    private String color;

    public Hairstyle(int length, String color) {
        this.length = length;
        this.color = color;
    }

    public Hairstyle() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Hairstyle{" +
                "length=" + length +
                ", color='" + color + '\'' +
                '}';
    }
}
