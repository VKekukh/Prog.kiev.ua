/**
 * Created by VKekukh on 12.09.2016.
 */
public class Print {
    boolean busy;
    String txt;

    public Print(String txt) {
        this.txt = txt;
    }

    public synchronized  void print (String txt){
        System.out.println(txt + ".......");
        busy = true;
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isBusy() {
        return busy;
    }
}
