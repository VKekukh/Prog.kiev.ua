import java.util.Random;
import java.util.Arrays;


public class Main {
public static void main(String[] args){
        int [] array   = {1, 2, 3};
        combination(array  ,0);

    }
    static void combination (int[] array  , int b){
        if (b == array  .length - 1){
            System.out.println(Arrays.toString(array  ));
        }
        else {
            for (int i = b; i < array  .length; i++){
                swith (array  ,b, i);
                combination (array  , b + 1);
                swith (array  , b, i);
            }
        }
    }
   
    static  void swith (int[] array  , int b, int i){
        int s = array  [b];
        array  [b] = array  [i];
        array  [i] = s;

    }
}