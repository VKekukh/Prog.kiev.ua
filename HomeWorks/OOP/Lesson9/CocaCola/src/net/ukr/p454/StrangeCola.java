package net.ukr.p454;

import java.util.Deque;

/**
 * Created by user on 17.09.2016.
 */
public class StrangeCola {

    public static void predictQueue(Deque<String> list, int amountBottles){
        for (int i = 0; i < amountBottles; i++) {
            list.addLast(list.pollFirst());
            list.addLast(list.peekLast());
        }
        System.out.println(list);
    }
}
