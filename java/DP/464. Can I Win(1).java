public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;

        for (int i = 1; i < maxChoosableInteger; i++) {
            if(canIWin(maxChoosableInteger, desiredTotal - i)) return false;
        }

        return true;
    }


}
