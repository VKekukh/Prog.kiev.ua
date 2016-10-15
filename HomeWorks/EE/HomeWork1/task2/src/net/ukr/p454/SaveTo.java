package net.ukr.p454;

import java.lang.annotation.*;

/**
 * Created by vkekukh on 15.10.2016.
 */

@Inherited
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface SaveTo {
    String path() default "text";
}
