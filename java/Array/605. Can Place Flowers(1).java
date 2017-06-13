public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length;) {
            if(n == 0) return true;
            if(flowerbed[i] == 1) i += 2;
            else {
                if(i == flowerbed.length - 1) {
                    n--;
                    i++;
                }
                else {
                    if(flowerbed[i + 1] == 0) {
                        n--;
                        i += 2;
                    }
                    else i += 3;
                }
            }
        }

        return n == 0;

    }
}
