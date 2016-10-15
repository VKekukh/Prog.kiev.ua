package net.ukr.p454;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by vkekukh on 15.10.2016.
 */
public class Reflect {
    public static void getMethods(Class<?>... lst) {

        for (Class<?> aClass : lst) {
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {

                int mods = method.getModifiers();

                if (method.isAnnotationPresent(Interception.class)) {
                    Interception annotation = method.getAnnotation(Interception.class);

                    if (Modifier.isPrivate(mods)) {
                        method.setAccessible(true);
                    }
                    try {
                        System.out.println(method.getName() + ":" + method.invoke(aClass, annotation.a(), annotation.b()));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
