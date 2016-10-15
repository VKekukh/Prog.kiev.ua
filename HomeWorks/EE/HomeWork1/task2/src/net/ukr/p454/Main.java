package net.ukr.p454;

import java.lang.reflect.Field;

/**
 * Created by vkekukh on 15.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        TextContainer container = new TextContainer("Text 1", "Text 2");

        SaveStringFields ssf = new SaveStringFields();
        ssf.saveFields(container);

    }
}
