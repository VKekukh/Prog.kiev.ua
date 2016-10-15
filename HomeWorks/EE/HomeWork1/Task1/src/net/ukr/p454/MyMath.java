package net.ukr.p454;

/**
 * Created by vkekukh on 15.10.2016.
 */
public class MyMath {

    @Interception(a = 3, b = 4)
    public static int sum(int a, int b) {
        return a + b;
    }

    @Interception
    private static int mult (int a, int b){
        return a * b;
    }

    public static int sub (int a, int b){
        return a- b;
    }
}
