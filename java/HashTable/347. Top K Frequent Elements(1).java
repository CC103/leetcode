import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 长度要等于理论最大频率nums.length，因为下标的原因，所以+1
        List<Integer> bucket[] = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i: map.keySet()) {
            int frequency = map.get(i);
            if(bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(i);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] == null) continue;

            for(int j: bucket[i]) {
                if(k == 0) break;
                res.add(j);
                k--;
            }

        }

        return res;
    }
}
