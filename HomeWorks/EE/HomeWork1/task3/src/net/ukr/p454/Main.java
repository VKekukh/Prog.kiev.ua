package net.ukr.p454;

import java.io.*;

/**
 * Created by Dalvik on 16.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Hairstyle hairstyle = new Hairstyle(10, "black");
        Human human = new Human("Ivan", 30, true, 80.1, 186, hairstyle);
        SpecialSerialize.saveObject(human);

        human.setAge(40);
        System.out.println("Old human " + human.toString());

        human = SpecialSerialize.loadObject("Human.txt");
        System.out.println("Restore human " + human.toString());
    }
}
