package net.ukr.p454;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Monitoring implements Runnable {
    Path path;

    public Monitoring(Path path) {
        this.path = path;
    }

    @Override
    public void run() {
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (WatchEvent event : key.pollEvents()) {
                switch (event.kind().name()) {
                    case "OVERFLOW":
                        System.out.println("We lost some events");
                        break;
                    case "ENTRY_CREATE":
                        System.out.println("File " + event.context()
                                + " is created!");
                        break;
                    case "ENTRY_MODIFY":
                        System.out.println("File " + event.context()
                                + " is modified!");
                        break;
                    case "ENTRY_DELETE":
                        System.out.println("File " + event.context()
                                + " is deleted!");
                        break;
                }

            }
            key.reset();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
