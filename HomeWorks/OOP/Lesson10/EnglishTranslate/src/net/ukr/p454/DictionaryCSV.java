package net.ukr.p454;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 16.09.2016.
 */
public class DictionaryCSV implements IDictionaryDAO {
    File file;

    public DictionaryCSV(File file) {
        this.file = file;
    }

    @Override
    public void saveDictionary(Dictionary dictionary) {

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (Map.Entry<String, String> word : dictionary.getDictionary().entrySet()) {
                writer.write(word.getKey() + ";" + word.getValue());
                writer.write(System.lineSeparator());
            }

        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    @Override
    public Dictionary loadDictionary() {
        Map<String, String> map = new HashMap<>();

        if (!file.exists()) {
            throw new IllegalArgumentException("Dictionary not exists");
        }

        String str = "";
        String[] array;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((str = reader.readLine()) != null) {
                array = str.split("[;]");
                map.put(array[0], array[1]);
            }
        } catch (IOException e) {
            System.err.println("Can't read file");
        }
        return new Dictionary(map, file.getName().substring(0, file.getName().lastIndexOf(".")));
    }
}
