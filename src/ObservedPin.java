import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObservedPin {
    public static List<String> getPINs(String observed){
        List<String> codes = new ArrayList<>();
        HashMap<Integer, Integer[]> values = new HashMap<>();
        values.put(0, new Integer[]{8});
        values.put(1, new Integer[]{2,4});
        values.put(2, new Integer[]{1,5,3});
        values.put(3, new Integer[]{2,6});
        values.put(4, new Integer[]{1,5,7});
        values.put(5, new Integer[]{2,4,6,8});
        values.put(6, new Integer[]{3,5,9});
        values.put(7, new Integer[]{4,8});
        values.put(8, new Integer[]{5,7,0,9});
        values.put(9, new Integer[]{6,8});



        return codes;
    } // getPINs



}
