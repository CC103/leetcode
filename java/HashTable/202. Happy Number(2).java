// two pointers
public class Solution {
    public boolean isHappy(int n) {
        int slow = digitSquare(n);
        int fast = digitSquare(digitSquare(n));

        while(slow != fast) {
            if(fast == 1) return true;
            slow = digitSquare(slow);
            fast = digitSquare(digitSquare(fast));
        }
        if(slow == 1) return true;
        return false;

    }

    public int digitSquare(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
