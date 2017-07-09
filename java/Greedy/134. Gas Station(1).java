public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gap[] = new int[gas.length];

        for(int i = 0; i < gap.length; i++) {
            gap[i] = gas[i] - cost[i];
        }

        for(int i = 0; i < gap.length; i++) {
            int start = i;
            int gasLeft = 0;
            boolean isFinished = true;

            for(int j = 0; j < gap.length; j++) {
                int index = (j + start) % gap.length;
                gasLeft += gap[index];
                if(gasLeft < 0) {
                    isFinished = false;
                    break;
                }
            }

            if(isFinished) return start;
        }

        return -1;
    }
}
