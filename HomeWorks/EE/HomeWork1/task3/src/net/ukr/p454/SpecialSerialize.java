package net.ukr.p454;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Dalvik on 16.10.2016.
 */
public class SpecialSerialize {

    public static void saveObject(Object obj, String path) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder builder = new StringBuilder();

        for (Field field : fields) {
            if (field.isAnnotationPresent(SaveFields.class)) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                try {
                    builder.append(field.getName() + ":" + field.get(obj));
                    builder.append(System.lineSeparator());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(path)) {
            pw.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadObject(Object obj, String path) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        Map<String, String> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] value = line.split(":");
                map.put(value[0], value[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Field field : fields) {
            if (map.containsKey(field.getName())) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                String type = field.getType().getName();

                try {
                    switch (type) {
                        case "java.lang.String":
                            field.set(obj, map.get(field.getName()));
                            break;
                        case "int": field.setInt(obj, Integer.valueOf(map.get(field.getName())));
                            break;
                        case "double": field.setDouble(obj, Double.valueOf(map.get(field.getName())));
                            break;
                        default:
                            System.out.println("Warning! Unknown type!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
