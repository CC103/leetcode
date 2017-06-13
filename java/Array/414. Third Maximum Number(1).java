public class Solution {
    public int thirdMax(int[] nums) {
        String s = "-2147483649";
        Long fir = Long.parseLong(s);
        Long sec = Long.parseLong(s);
        Long thir = Long.parseLong(s);


        for (int i : nums) {
            if (i > fir) {
                thir = sec;
                sec = fir;
                fir = Long.valueOf(i);
            }

            else if(i > sec && i < fir) {
                thir = sec;
                sec = Long.valueOf(i);
            }

            else if(i > thir && i < sec) {
                thir = Long.valueOf(i);
            }
        }

        return thir.equals(Long.parseLong(s)) ? fir.intValue() : thir.intValue();

    }
}
