package net.ukr.p454;

import java.io.File;

/**
 * Created by vkekukh on 07.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        File from  = new File("D:/Install");
        File to  = new File("D:/test");
        //FileOperation.copyFiles(from,to,"exe");
        FileOperation.multiThreadedCopying(from,to,"exe");

        System.out.println("Copying files have finished");
    }
}
