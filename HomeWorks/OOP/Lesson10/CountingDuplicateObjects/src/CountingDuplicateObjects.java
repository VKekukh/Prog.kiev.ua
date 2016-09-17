import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 17.09.2016.
 */
public class CountingDuplicateObjects <T>{

    public CountingDuplicateObjects() {
    }

    public void countingDuplicateObjects(T[] array){
        Map<T,Integer> countMap = new HashMap<>();
        for (T t : array) {
            if (countMap.containsKey(t)){
                countMap.put(t,countMap.get(t)+1);
            }else {
                countMap.put(t,1);
            }
        }

        System.out.println(countMap);
    }
}
