public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        if(s.contains("IV")) sum -= 2;
        if(s.contains("IX")) sum -= 2;
        if(s.contains("XL")) sum -= 20;
        if(s.contains("XC")) sum -= 20;
        if(s.contains("CD")) sum -= 200;
        if(s.contains("CM")) sum -= 200;

        for(char c: s.toCharArray()) {
            switch (c) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
            }
        }
        return sum;

    }
}
