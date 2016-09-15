package net.ukr.p454;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkekukh on 15.09.2016.
 */
public class AsciiConversion {
    private static Map<Character, String> dictionary = new HashMap<>();

    private static void createDictionary() {
        File file = new File("letters.txt");

        if (!file.exists()) {
            throw new IllegalArgumentException("File not exists");
        }
        String line = "";
        Character character = ' ';

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while ((line = reader.readLine()) != null) {
                if (!character.equals(line.replaceAll("[ ]+", "").charAt(0))) {
                    dictionary.put(character, builder.toString() + " ");
                    character = line.replaceAll("[ ]+", "").charAt(0);
                    builder = new StringBuilder();
                    builder.append(line);
                    builder.append(System.lineSeparator());
                } else {
                    builder.append(line);
                    builder.append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.println("Can't read the file" + file.getName());
        }

        //Add space
        builder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            builder.append("\t\t");
            builder.append(System.lineSeparator());
        }
        dictionary.put(' ', builder.toString());
    }

    public static void asciiConversion(String text, boolean rotate) {
        createDictionary();
        File file = new File("ascii.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] characters = text.toUpperCase().toCharArray();

        if (rotate) {
            try (PrintWriter writer = new PrintWriter(file)) {
                StringBuilder builder = new StringBuilder();
                String str[];

                for (int i = 0; i < 16; i++) {
                    for (char character : characters) {
                        str = dictionary.get(character).split(System.lineSeparator());
                        builder.append(str[i]);
                        builder.append("   ");
                    }
                    builder.append(System.lineSeparator());
                }
                writer.write(builder.toString());
                System.out.println(builder.toString());
            } catch (IOException e) {
                System.err.println("Can't write file");
            }

        } else {
            StringBuilder builder = new StringBuilder();
            try (PrintWriter writer = new PrintWriter(file)) {
                for (char character : characters) {
                    builder.append(dictionary.get(character));
                    builder.append(System.lineSeparator());
                }
                System.out.println(builder.toString());
                writer.write(builder.toString());
            } catch (IOException e) {
                System.err.println("Can't write file");
            }
        }
    }
}
