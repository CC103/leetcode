/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, h = n, mid;

        while(l <= h) {
            mid = l + (h - l) / 2;
            if(guess(mid) == 0) return mid;

            else if(guess(mid) < 0) h = mid - 1;

            else l = mid + 1;
        }
        return 0;
    }
}
