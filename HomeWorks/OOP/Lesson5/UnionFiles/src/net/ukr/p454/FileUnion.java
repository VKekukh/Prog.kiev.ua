package net.ukr.p454;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUnion {

    public static void union(File fileOne, File fileTwo) {

        String textFileOne = readFile(fileOne);
        String textFileTwo = readFile(fileTwo);

        textFileOne = textFileOne.replaceAll("[.,:;/=\")(]", " ").replaceAll(System.lineSeparator(), " ").replaceAll("[ ]+",
                " ");
        String[] array = textFileOne.split(" ");

        String[] repeatingWords = getRepeatingWords(array, textFileTwo);

        writeRepeatWord(repeatingWords);
    }

    public static String readFile(File file) {

        StringBuilder builder = new StringBuilder();
        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
            return builder.toString();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    private static String[] getRepeatingWords(String[] array, String text) {
        String[] repeatingWords = new String[0];
        int position = 0;

        for (int i = 0; i < array.length; i++) {
            if (text.toLowerCase().contains(array[i].toLowerCase())) {
                repeatingWords = increaseArray(repeatingWords);
                repeatingWords[position++] = array[i];

            }
        }
        return repeatingWords;
    }

    private static String[] increaseArray(String[] array) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    private static void writeRepeatWord(String[] repeatingWords) {
        try (PrintWriter printWriter = new PrintWriter(new File("union.txt"))) {
            for (String word : repeatingWords) {
                printWriter.println(word);
            }
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }
}