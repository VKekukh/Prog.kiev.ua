package net.ukr.p454;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


/**
 * Created by Dalvik on 16.10.2016.
 */
public class Human implements Externalizable{

    @SaveFields
    private String name;

    @SaveFields
    private int age;
    @SaveFields
    private Boolean sex;
    @SaveFields
    private double weight;
    private int height;
    @SaveFields
    private Hairstyle hairstyle;


    public Human() {
    }

    public Human(String name, int age, Boolean sex, double weight, int height, Hairstyle hairstyle) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.hairstyle = hairstyle;
    }


    public Human(String name, int age, Boolean sex, double weight, int height) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public Human(String name, int age, Boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Hairstyle getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(Hairstyle hairstyle) {
        this.hairstyle = hairstyle;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", weight=" + weight +
                ", height=" + height +
                ", hairstyle=" + hairstyle +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(name);
        out.writeInt(age);
        out.writeObject(sex);
        out.writeDouble(weight);
        out.writeInt(height);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        name = (String) in.readObject();
        age = (Integer) in.readInt();
        sex = (Boolean) in.readBoolean();
        weight = (Double) in.readDouble();
        height = (Integer) in.readInt();
    }

}
