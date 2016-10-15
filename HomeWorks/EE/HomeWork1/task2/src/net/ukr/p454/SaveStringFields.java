package net.ukr.p454;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by vkekukh on 15.10.2016.
 */
public class SaveStringFields<T> {

    public void saveFields(T obj) {

        Class<?> cls = obj.getClass();

        //Does a class have a Saver ?
        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {

                //Private or no
                int mod = method.getModifiers();
                if (Modifier.isPrivate(mod)) {
                    method.setAccessible(true);
                }

                //Find fields which need to save
                Field[] fields = cls.getDeclaredFields();
                for (Field field : fields) {

                    if (field.isAnnotationPresent(SaveTo.class)) {

                        int modF = field.getModifiers();
                        if (Modifier.isPrivate(modF)) {
                            field.setAccessible(true);
                        }

                        try {
                            String txt = (String) field.get(obj);
                            SaveTo saveTo = field.getAnnotation(SaveTo.class);

                            method.invoke(obj,saveTo.path(),txt);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        }
        System.out.println("Saved!");
    }
}
