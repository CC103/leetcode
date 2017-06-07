import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> summaryRanges(int[] nums) {
      if(nums.length == 0) return new ArrayList<>();

      List<String> res = new ArrayList<>();
      int start, end;

      for(start = 0; start < nums.length;) {
          end = start;
          while(end < nums.length - 1 && nums[end + 1] == nums[end] + 1) {
              end++;
          }

          // Generate string
          if(end == start) {
              res.add(nums[start] + "");
          }
          else {
              res.add(nums[start] + "->" + nums[end]);
          }
          start = end + 1;
      }

      return res;
  }
}
