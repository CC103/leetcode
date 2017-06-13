public class Solution {
    public int thirdMax(int[] nums) {
        Integer fir = null;
        Integer sec = null;
        Integer thir = null;




        for (Integer i : nums) {
            if(i == fir || i == sec || i== thir) continue;

            if (fir == null || i > fir) {
                thir = sec;
                sec = fir;
                fir = i;
            }

            else if(sec == null || (i > sec)) {
                thir = sec;
                sec = i;
            }

            else if(thir == null || (i > thir)) {
                thir = i;
            }
        }

        return thir == null ? fir : thir;

    }
}
