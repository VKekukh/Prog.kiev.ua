package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Box implements Cloneable{
    private int weight;
    private String content;

    public Box(String content, int weight) {
        this.weight = weight;
        this.content = content;
    }

    public Box() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Box contents " + content + " weight " + weight;
    }

    @Override
    public  Box clone()  {
        try {
            return (Box) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
