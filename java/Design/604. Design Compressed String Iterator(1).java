import java.util.ArrayList;
import java.util.List;

public class StringIterator {
    List<Character> chars;
    List<Integer> frequency;
    int index;
    int sum;

    public StringIterator(String compressedString) {
        chars = new ArrayList<>();
        frequency = new ArrayList<>();

        int cur = 0;

        // recover original string
        while (cur < compressedString.length()) {
            char c = compressedString.charAt(cur);
            int end = cur + 1;
            while (end < compressedString.length() && Character.isDigit(compressedString.charAt(end))) end++;
            int num = Integer.valueOf(compressedString.substring(cur + 1, end));

            chars.add(c);
            frequency.add(num);

            cur = end;
        }

        index = 0;
        sum = 0;
    }

    public char next() {
        if (!hasNext()) return ' ';
        char res = chars.get(index);

        sum++;
        if (sum == frequency.get(index)) {
            index++;
            sum = 0;
        }
        return res;
    }

    public boolean hasNext() {
        if (index == frequency.size()) return false;
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
