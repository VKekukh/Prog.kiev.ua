package net.ukr.p454;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by vkekukh on 07.09.2016.
 */
public class MultiThreadedCopying implements Callable<Long>{
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

        System.out.println("File " + from.getName() + " copying ..." );
    }
/*
    @Override
    public void run() {
        FileOperation.copyFile(from, to);
    }*/

    @Override
    public Long call() throws Exception {
        FileOperation.copyFile(from, to);
        return from.length();
    }
}
