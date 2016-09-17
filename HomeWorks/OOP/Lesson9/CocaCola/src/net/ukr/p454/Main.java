package net.ukr.p454;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by user on 17.09.2016.
 */
public class Main {
        public static void main(String[] args) {
            Deque<String> deque = new ArrayDeque<>();
            deque.add("Sheldon");
            deque.add("Leonard");
            deque.add("Volovitc");
            deque.add("Kutrapalli");
            deque.add("Penny");

            StrangeCola.predictQueue(deque,5);
        }
}
