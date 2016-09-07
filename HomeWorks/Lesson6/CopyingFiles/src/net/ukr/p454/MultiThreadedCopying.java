package net.ukr.p454;

import java.io.File;

/**
 * Created by vkekukh on 07.09.2016.
 */
public class MultiThreadedCopying implements Runnable{
    private File from;
    private File to;

    public MultiThreadedCopying() {
    }

    public MultiThreadedCopying(File from, File to) {
        this.from = from;
        this.to = to;
        System.out.println("File " + from.getName() + " copying ...");
    }

    public MultiThreadedCopying(File from, File to, String threadName) {
        this.from = from;
        this.to = to;

        System.out.println("File " + from.getName() + " copying ...");
    }

    @Override
    public void run() {
        FileOperation.copyFile(from, to);
    }
}
