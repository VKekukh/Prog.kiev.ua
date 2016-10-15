package net.ukr.p454;

import java.lang.annotation.*;

/**
 * Created by vkekukh on 15.10.2016.
 */

@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface Interception {
    int a() default 2;
    int b() default 3;
}
