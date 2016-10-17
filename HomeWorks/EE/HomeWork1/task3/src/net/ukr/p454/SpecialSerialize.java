package net.ukr.p454;

import com.sun.org.apache.xpath.internal.operations.Bool;

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

    public static void saveObject(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        builder.append("class" + ":" + obj.getClass().getName());
        builder.append(System.lineSeparator());
        for (Field field : fields) {

            if (field.isAnnotationPresent(SaveFields.class)) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                try {
                    //Is it  standart type or no ?
                    if (checkStandartType(field.getType())) {
                        builder.append(field.getName() + ":" + field.get(obj));
                        builder.append(System.lineSeparator());

                    } else {
                        builder.append(field.getName() + ":");
                        //check value on null
                        if (field.get(obj) != null) {
                            saveObject(field.get(obj));
                            builder.append(field.getType().getName().substring(cls.getPackage().getName().length() + 1) + ".txt");
                        } else {
                            builder.append("null");
                        }
                        builder.append(System.lineSeparator());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(cls.getName().substring(cls.getPackage().getName().length() + 1) + ".txt")) {
            pw.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T loadObject(String path) {
        T obj = null;

        Map<String, String> map = new HashMap<>();

        //fill a map
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] value = line.split(":");
                map.put(value[0], value[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class<?> cls = null;
        try {
            cls = Class.forName(map.get("class"));

            obj = (T) cls.newInstance();

            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {

                if (map.containsKey(field.getName())) {

                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }

                    //Is it  standart type or no ?
                    if (checkStandartType(field.getType())){
                        String type = field.getType().getName();

                        switch (type) {
                            case "java.lang.String":
                                field.set(obj, map.get(field.getName()));
                                break;
                            case "int":
                                field.setInt(obj, Integer.valueOf(map.get(field.getName())));
                                break;
                            case "double":
                                field.setDouble(obj, Double.valueOf(map.get(field.getName())));
                                break;
                            case "java.lang.Boolean":
                                field.set(obj, Boolean.valueOf(map.get(field.getName())));
                                break;
                            default:
                                System.out.println("Warning! Unknown type!");
                        }
                    } else {
                        if (!map.get(field.getName()).equalsIgnoreCase("null")){
                            field.set(obj, SpecialSerialize.loadObject(map.get(field.getName())) );
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean checkStandartType(Class<?> cls) {

        if (cls.isPrimitive() || (cls.getPackage().getName().equalsIgnoreCase("java.lang"))) {
            return true;
        } else {
            return false;
        }
    }
}
