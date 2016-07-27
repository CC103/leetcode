class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int c1 = INT_MAX;
        int c2 = INT_MAX;
        //Keep updating a window with size 3
        for(int i : nums){
            if(i <= c1)
                c1 = i;
            else if(i <= c2)
                c2 = i;
            else
                //There is exist that c1 < c2 < i
                return true;
        }
        return false;
    }
};
