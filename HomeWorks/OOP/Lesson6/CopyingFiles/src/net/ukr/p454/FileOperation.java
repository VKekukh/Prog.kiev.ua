package net.ukr.p454;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Created by vkekukh on 07.09.2016.
 */
public class FileOperation{
    private static int bufferSize = 1024 * 1024;
    private File from;
    private File to;

    FileOperation() {
        super();

    }

    public static void copyFile(File from, File to) throws IllegalArgumentException {


        try (FileInputStream input = new FileInputStream(from); FileOutputStream output = new FileOutputStream(to)) {

            if (from == null || to == null) {
                throw new IllegalArgumentException("Null pointer");
            }

            byte[] buffer = new byte[bufferSize];
            int readBytes = 0;
            while ((readBytes = input.read(buffer, 0, bufferSize)) != -1) {
                output.write(buffer, 0, readBytes);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void copyFiles(File folderSource, File folderDestination, String extension) {
        int copiedFiles = 0;
        Long copiedSize = 0L;

        // Create folders if they don't exists
        if (!folderDestination.exists()) {
            folderDestination.mkdirs();
        }

        File[] fileList = getFileList(folderSource, extension);

        for (File copiersFile : fileList) {
            copyFile(copiersFile, new File(folderDestination, copiersFile.getName()));
            copiedFiles++;
            copiedSize += copiersFile.length();
            System.out.println(
                    ">>> File " + copiersFile.getName() + " is copied to " + folderDestination.getPath() + ">>>");

        }
        System.out.println("--------------------");
        System.out.println("Copied: " + copiedFiles + " files " + ". Full Size: " + copiedSize/1024/1024 + " Mb");
    }

    public static void setBufferSize(int bufferSize) {
        FileOperation.bufferSize = bufferSize;
    }

    public static void multiThreadedCopying(File folderSource, File folderDestination, String extension){

        File[] fileList = getFileList(folderSource, extension);
        Thread[] threadList = new Thread[fileList.length];

        if (!folderDestination.exists()) {
            folderDestination.mkdirs();
        }

        for (int i = 0; i < fileList.length; i++) {
            threadList[i] = new Thread(new MultiThreadedCopying(fileList[i],new File(folderDestination, fileList[i].getName()),"Thread " + i));
            threadList[i].start();
        }

        System.out.println("All threads is running");

        for (int i = 0; i < fileList.length; i++) {

            try {
                threadList[i].join();
            }catch (InterruptedException e){
                System.err.println(e);
            }

        }

    }

    private static File[] getFileList(File folderSource, String extension){

        // interface FileFilter implementation
        FileFilter filter = (File file) -> {
            if (file.isDirectory()) {
                return false;
            }

            String fileExt = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            return extension.contains(fileExt);
        };

        return folderSource.listFiles(filter);
    }

}
