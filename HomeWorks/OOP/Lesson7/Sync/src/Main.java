/**
 * Created by VKekukh on 12.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        Print print = new Print("Test");
        Thread threadOne = new Thread(new TestThread(print, "txt"));
        Thread threadTwo = new Thread(new TestThread(print,"test2"));
        threadOne.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(print.isBusy());

        threadTwo.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(print.isBusy());

    }

}
