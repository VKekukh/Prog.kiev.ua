package net.ukr.p454;

/**
 * Created by vkekukh on 14.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        SomeList<Integer> list = new SomeList<>();

        for (int i = 0; i < 10; i++) {
            list.addToList(i);
        }

        list.removeTwoFirstAndOneLast();
    }
}
