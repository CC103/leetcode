public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int tank = 0;

        for(int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
}
