package net.ukr.p454;

import java.io.*;

/**
 * Created by Dalvik on 16.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human("Ivan", 30, 'M', 80.1, 186);
        System.out.println(human.toString());

        SpecialSerialize.saveObject(human,"fields.txt");

        Human newHuman = new Human();

        SpecialSerialize.loadObject(newHuman,"fields.txt");
        System.out.println("Deserialize:" + newHuman.toString());
    }
}
