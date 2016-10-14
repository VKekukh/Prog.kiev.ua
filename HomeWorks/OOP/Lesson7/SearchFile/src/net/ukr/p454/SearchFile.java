package net.ukr.p454;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by VKekukh on 12.09.2016.
 */
public class SearchFile implements Runnable{
    private String fileName;
    private File folder;

    public SearchFile(String fileName, File folder) {
        this.fileName = fileName;
        this.folder = folder;
    }

    public SearchFile() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public static  void searchFile(String fileName, File folder){

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        if(!folder.isDirectory()||!folder.exists()){
            throw new IllegalArgumentException("Isn't correct folder for searching file");
        }

        File[] list = folder.listFiles();
        for (File file : list) {
            if (file.isDirectory()){
                service.submit(new SearchFile(fileName, file));
            }else {
                if (file.getName().equalsIgnoreCase(fileName)){
                    System.out.println(file.getAbsolutePath());
                }
            }

        }

        service.shutdown();
    }

    @Override
    public void run() {
        searchFile(this.fileName, this.folder);
    }
}
