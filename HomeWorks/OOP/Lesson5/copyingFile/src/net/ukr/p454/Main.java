package net.ukr.p454;

import java.io.File;

/**
 * Created by VKekukh on 09.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        FileOperation.copyFiles(new File("D:/Install"),new File("D:/copy"),"zip");
    }
}
