/**
 * Created by user on 17.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        CountingDuplicateObjects<String> counting = new CountingDuplicateObjects<>();
        String[] strArray = {"Hello", "world","java","java"};
        counting.countingDuplicateObjects(strArray);

        Integer[] intArray = {1,1,2,3,4,4,5};
        CountingDuplicateObjects<Integer> countInt = new CountingDuplicateObjects<>();
        countInt.countingDuplicateObjects(intArray);
    }
}
