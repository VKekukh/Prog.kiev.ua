package net.ukr.p454;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Dalvik on 10.09.2016.
 */
public class FileOperation {

    private static String extension;

    private static void setExtension(String ext){
        extension = ext;
    }

    public static void copyFile(File from, File to, boolean replase) throws FileAlreadyExistsException {

        if (from == null || !from.exists()) {
            throw new IllegalArgumentException("File source is not correct");
        }


        Path pathFrom = Paths.get(from.getAbsolutePath());
        Path pathTo = Paths.get(to.getAbsolutePath());

        if (replase) {
            try {
                Files.copy(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.copy(pathFrom, pathTo);
            } catch (IOException e) {
                throw new FileAlreadyExistsException("File " + pathTo.getFileName() + " in directory " + pathTo.getParent() + " already exists");
            }
        }
    }

    public static void copyFiles(File folderSource, File folderDestination, String ext, boolean replace) {
        setExtension(ext);

        if (!folderSource.isDirectory() || !folderSource.exists()) {
            throw new IllegalArgumentException("Folder source isn't correct");
        }

        if (!folderDestination.exists()) {
            folderDestination.mkdirs();
        }

        FileFilter filter = FileOperation::accept;
        File[] fileList = folderSource.listFiles(filter);

        for (File file : fileList) {
            try {
                copyFile(file, new File(folderDestination, file.getName()), replace);
                System.out.println(file.getAbsolutePath() + " is been copying to " + folderDestination.getName());
            } catch (FileAlreadyExistsException e) {
                System.err.println(e);
            }
        }
    }

    public static void moveFile(File from, File to, boolean replase) throws FileAlreadyExistsException {

        if (from == null || !from.exists()) {
            throw new IllegalArgumentException("File source is not correct");
        }


        Path pathFrom = Paths.get(from.getAbsolutePath());
        Path pathTo = Paths.get(to.getAbsolutePath());

        if (replase) {
            try {
                Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.move(pathFrom, pathTo);
            } catch (IOException e) {
                throw new FileAlreadyExistsException("File " + pathTo.getFileName() + " in directory " + pathTo.getParent() + " already exists");
            }
        }
    }

    public static void moveFiles(File folderSource, File folderDestination, String ext, boolean replace) {
        setExtension(ext);

        if (!folderSource.isDirectory() || !folderSource.exists()) {
            throw new IllegalArgumentException("Folder source isn't correct");
        }

        if (!folderDestination.exists()) {
            folderDestination.mkdirs();
        }

        FileFilter filter = FileOperation::accept;
        File[] fileList = folderSource.listFiles(filter);

        for (File file : fileList) {
            try {
                moveFile(file, new File(folderDestination, file.getName()), replace);
                System.out.println(file.getAbsolutePath() + " is been moving to " + folderDestination.getName());
            } catch (FileAlreadyExistsException e) {
                System.err.println(e);
            }
        }
    }

    private static boolean accept(File pathname) {

        if (pathname.isDirectory()) {
            return false;
        }

        String fileExt = pathname.getName().substring(pathname.getName().indexOf('.') + 1);
        String[] extensions = extension.split(";");

        for (String ext : extensions) {
            if (ext.equalsIgnoreCase(fileExt)) {
                return true;
            }
        }
        return false;
    }
}
