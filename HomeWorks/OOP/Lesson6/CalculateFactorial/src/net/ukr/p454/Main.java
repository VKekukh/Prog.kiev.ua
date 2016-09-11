package net.ukr.p454;

/**
 * Created by Dalvik on 11.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Thread [] threads = new Thread[10000];
        for (int i = 0; i < threads.length ; i++) {
            threads[i] = new Thread(new Factorial(i), "SubThread " + i);
            threads[i].start();
        }

        for (int i = 0; i <threads.length ; i++) {
            try{
                threads[i].join();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }

        System.out.println(Thread.currentThread() + " finished");

    }
}
