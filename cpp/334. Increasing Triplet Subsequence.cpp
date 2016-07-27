class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        if(nums.size() < 3)
            return false;
        vector<int> subseq;
        for(int i = 0; i < nums.size() - 2; i++){
            subseq.push_back(nums[i]);
            for(int j = i + 1; j < nums.size() - 1; j++){
                if(nums[j] > subseq.back()){
                    subseq.push_back(nums[j]);
                    for(int p = j + 1;  p < nums.size(); p++){
                        if(nums[p] > subseq.back()){
                            //subseq.push_back(nums[p]);
                            return true;
                        }
                    }
                    subseq.pop_back();
                }
            }
            subseq.pop_back();
        }

        return false;
    }
};
