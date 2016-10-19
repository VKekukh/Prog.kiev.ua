package net.ukr.p454;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by VKekukh on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder builder  = new StringBuilder();
        String line = "";
        try (BufferedReader reader  = new BufferedReader(new FileReader("json.txt"))){
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = builder.toString();

        Gson gson = new GsonBuilder().create();

        Person person = gson.fromJson(result, Person.class);

        System.out.println(person.getName().toString());
        System.out.println(person.getAddress().getCity().toString());
    }
}
