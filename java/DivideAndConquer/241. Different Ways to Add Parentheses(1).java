import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for(int a: left) {
                    for(int b: right) {
                        int d = 0;
                        switch(c) {
                            case '+':
                                d = a + b;
                                break;
                            case '-':
                                d = a - b;
                                break;
                            case '*':
                                d = a * b;
                        }

                        res.add(d);
                    }
                }
            }
        }

        if(res.size() == 0) res.add(Integer.valueOf(input));

        return res;

    }

    public static void main(String[] arg) {
        Solution s = new Solution();
        s.diffWaysToCompute("2+2-3");
    }

}
