/**
 * Created by VKekukh on 12.09.2016.
 */
public class TestThread implements  Runnable {
    Print print;
    String txt;
    public TestThread(Print print,String txt) {
        this.print = print;
        this.txt = txt;
    }

    @Override
    public void run() {
        print.print(txt);
    }
}
