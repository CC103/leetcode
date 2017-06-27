public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while(n > 1) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length(); i++) {
                char digit = s.charAt(i);
                int count = 1;

                while(i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                    count++;
                    i++;
                }

                sb.append(count + "" + digit);
            }

            s = sb.toString();
            n--;
        }

        return s;

    }
}
