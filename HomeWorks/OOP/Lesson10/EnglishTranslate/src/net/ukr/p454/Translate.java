package net.ukr.p454;

import java.io.*;

/**
 * Created by user on 16.09.2016.
 */
public class Translate {
    Dictionary dictionary;

    public Translate(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(String txt) {
        String[] array = txt.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String word : array) {
            builder.append((dictionary.searchWord(word) == null) ? word : dictionary.searchWord(word));
            builder.append(" ");
        }
        return builder.toString();
    }

    public void translate(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException("File not exists");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file)); BufferedWriter writer = new BufferedWriter(new FileWriter("translate.out"))) {
            String line;
            while ((line = reader.readLine())!= null){
                writer.write(translate(line));
                writer.write(System.lineSeparator());
            }

        } catch (IOException e) {
            System.err.println("Input/Output error");
        }
    }
}
