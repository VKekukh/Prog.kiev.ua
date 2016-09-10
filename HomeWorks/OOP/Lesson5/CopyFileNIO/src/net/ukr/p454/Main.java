package net.ukr.p454;

import java.io.File;

/**
 * Created by Dalvik on 10.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        File from = new File("d:/");
        File to = new File("d:/test");

        FileOperation.copyFiles(from, to, "txt", false);

        from = new File("D:/test");
        to = new File("D:/test/move");

        FileOperation.moveFiles(from, to, "txt", true);

    }
}
