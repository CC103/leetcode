class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int length = gas.size();
        for(int i = 0; i < length; i++){
            if(check(gas, cost, i))
                return i;
        }
        return -1;
    }

    bool check(vector<int> &gas, vector<int> &cost, int index){
        int length = gas.size();
        int myGas = 0;
        int flag = 0;
        for(int i = index; ; i++){
            i = i % length;
            if(flag == 1 && i == index)
                return true;
            flag = 1;
            if(myGas + gas[i] < cost[i])
                return false;
            else
                myGas = myGas + gas[i] - cost[i];
        }

    }
};
