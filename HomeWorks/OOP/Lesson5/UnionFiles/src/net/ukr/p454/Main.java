package net.ukr.p454;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("D:/file1.txt");
        File file2 = new File("D:/file2.txt");
        FileUnion.union(file, file2);
    }

}