public class Solution {
    private String LESS_THAN_20[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String TENS[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String THOUSANDS[] = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        int i = 0;
        String words = "";

        while(num > 0) {
            if(num % 1000 != 0) words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();

    }

    public String helper(int n) {
        if(n == 0) return "";

        if(n < 20) return LESS_THAN_20[n] + " ";

        else if(n < 100) return TENS[n / 10] + " " + helper(n % 10);

        else return LESS_THAN_20[n / 100] + " Hundred " + helper(n % 100);

    }
}
