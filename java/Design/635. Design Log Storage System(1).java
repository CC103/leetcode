import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogSystem {
    // 2017:01:01:23:59:59
    List<String[]> timestamps;
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = {4, 7, 10, 13, 16, 19};

    public LogSystem() {
        timestamps = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        timestamps.add(new String[]{id + "", timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = units.indexOf(gra);
        int end = indices[index];
        List<Integer> res = new ArrayList<>();
        String ss = s.substring(0, end);
        String se = e.substring(0, end);

        for (String[] arr: timestamps) {
            if (arr[1].substring(0, end).compareTo(ss) >= 0 && arr[1].substring(0, end).compareTo(se) <= 0) res.add(Integer.valueOf(arr[0]));
        }

        return res;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
