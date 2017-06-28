public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int i = 0;

        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }

        boolean isNegative = false;
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if(str.charAt(i) == '-') isNegative = true;
            i++;
        }

        int result = 0;

        while(i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            int digit = str.charAt(i) - '0';


            if(isNegative) {
                if(-result >= (min + digit) / 10) result = result * 10 + digit;
                else return min;
            }
            // positive
            else {
                if(result <= (max - digit) / 10) result = result * 10 + digit;
                else return max;
            }

            i++;
        }

        return isNegative ? -result : result;

    }

}
