public class Solution {
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char res[] = new char[num.length()];
        int top = 0;

        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(top > 0 && res[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            res[top++] = c;
        }

        int x = 0;
        while(x < digits && res[x] == '0') x++;
        return x == digits ? "0" : new String(res, x, digits - x);

    }
}
