class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int sum = 0, tank = 0, start = 0;
        int length = gas.size();
        for(int i = 0; i < length; i++){
            //tank has been updated now
            if((tank = tank + gas[i] - cost[i]) < 0){
                //change the start
                start = i + 1;
                //record the total gas value
                sum += tank;
                //initialize the tank because we get new start now 
                tank = 0;
            }
        }
        //when i = length and tank + gas[i] - cost[i] < 0, the loop is end and tank + sum must smaller than 0, so there is not a solution. 
        //为什么这时候一定无解，因为此时的tank已经是在这个位置可能存在的最大值，还是无法到达则说明不可抵达
        if(tank + sum >= 0)
            return start;
        return -1;
    }

};
