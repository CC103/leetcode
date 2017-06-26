public class Solution {
    public int arrangeCoins(int n) {
        if(n < 1) return 0;
        int num = 1;
        n -= 1;

        num++;
        while(n >= num) {
            n -= num;
            num++;
        }

        return num - 1;
    }
}
