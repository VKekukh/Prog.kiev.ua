package net.ukr.p454;

import java.io.*;

/**
 * Created by VKekukh on 09.09.2016.
 */
public class FileOperation {
    static int length = 1024 * 1024;
    static byte[] buffer;

    public static void setLength(int length) {
        FileOperation.length = length;
    }

    public static void copyFile(File from, File to) {
        if (from == null || !from.exists() || from.isDirectory()) {
            throw new IllegalArgumentException("Wrong file source");
        }

        buffer = new byte[length];
        int readByte = 0;

        try (FileInputStream reader = new FileInputStream(from);
             FileOutputStream writer = new FileOutputStream(to)) {

            while ((readByte = reader.read(buffer)) > 0) {
                writer.write(buffer,0,readByte);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void copyFiles(File folderSource, File folderDestination, String extension) {
        if (!folderSource.isDirectory() || !folderSource.exists()) {
            throw new IllegalArgumentException("Folder source isn't correct");
        }

        if (!folderDestination.exists()) {
            folderDestination.mkdirs();
        }

        File[] fileList = folderSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                if (pathname.isDirectory()) {
                    return false;
                }

                String fileExt = pathname.getName().substring(pathname.getName().indexOf('.') + 1);

                if (extension.contains(fileExt)) {
                    return true;
                } else {
                    return false;
                }

            }
        });

        for (File file : fileList) {
            copyFile(file, new File(folderDestination, file.getName()));
            System.out.println(file.getAbsolutePath() + " is been copying to " + folderDestination.getName());
        }
    }


}
