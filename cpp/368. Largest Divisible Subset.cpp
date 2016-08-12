class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        if(nums.empty())
            return vector<int>(0);
        sort(nums.begin(), nums.end());
        // the length of the largest divisible subset whose largest number is nums[n]
        vector<int> L(nums.size(), 1);
        //save the last node position of subset whose largest number is nums[n]
        vector<int> parent(nums.size(), -1);
        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0)
                    if(1 + L[j] > L[i]){
                        L[i] = L[j] + 1;
                        parent[i] = j;
                    }                
            }
        }
        int max = L[0];
        int pos = 0;
        for(int i = 0; i < L.size(); i++){
            if(L[i] > max){
                max = L[i];
                pos = i;
            }
        }
        vector<int> res;
        while(pos != -1){
            res.push_back(nums[pos]);
            pos = parent[pos];
        }
        // sort(res.begin(), res.end());
        return res;

    }
}; 
