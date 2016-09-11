package net.ukr.p454;

import java.nio.file.Paths;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Monitoring monitoring = new Monitoring(Paths.get("D:/test"));
        Thread thread = new Thread(monitoring);
        thread.start();
    }
}
