/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // index start from 1
        // store how many people knows him
        int[] num1 = new int[n];
        // store how many people he knows
        int[] num2 = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (knows(i, j)) {
                    num1[j]++;
                    if(num2[i] == 0) num2[i] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
          if(num1[i] == n - 1 && num2[i] == 0) return i;
        }
        return -1;
    }
}
