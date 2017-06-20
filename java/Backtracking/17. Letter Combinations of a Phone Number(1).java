import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> combinations = new LinkedList<>();
        if(digits.length() == 0) return combinations;
        String map[] = {"0", "1" ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations.add("");

        for(int i = 0; i < digits.length(); i++) {
            int digit = Integer.valueOf(digits.charAt(i) + "");
            while(combinations.peek().length() == i) {
                String s = combinations.remove();
                for(char c: map[digit].toCharArray()) {
                    combinations.add(s + c);
                }
            }
        }

        return combinations;

    }
}
