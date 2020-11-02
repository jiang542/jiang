import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDao {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(234);
        intList.add(567);

        Integer[] arrA = new Integer[3];
        intList.toArray(arrA);
        System.out.println(Arrays.toString(arrA));

        Integer[] arrB = intList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrB));

    }
}
