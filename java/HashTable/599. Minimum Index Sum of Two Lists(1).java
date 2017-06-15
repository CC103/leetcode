import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();

        int i = 0;
        for(String s: list1) {
            map.put(s, i++);
        }

        int j = -1;
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for(String s: list2) {
            j++;

            if(!map.containsKey(s)) continue;

            if(j + map.get(s) < min) {
                min = j + map.get(s);
                res.clear();
                res.add(s);
            }
            else if(j + map.get(s) == min) res.add(s);

        }

        String ret[] = new String[res.size()];
        i = 0;
        for(String s: res) {
            ret[i++] = s;
        }

        return  ret;

    }

}
