package net.ukr.p454;

import java.lang.annotation.*;

/**
 * Created by Dalvik on 16.10.2016.
 */

@Inherited
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface SaveFields {

}
