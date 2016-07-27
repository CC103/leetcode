class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        //lenLIS 存着nums在0-i的范围内，以nums[i]结束的LIS的长度
        int size = nums.size();
        int *lenLIS = new int[size];
        for(int i = 0; i < size; i++){
            lenLIS[i] = 1;
        }

        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                //以nums[j]结尾的增长序列可以拼到nums[i]前
                if(nums[j] < nums[i]){
                    //如果长度不及现有的最大值就没必要存了
                    if(lenLIS[j] + 1 > lenLIS[i])
                        lenLIS[i] = lenLIS[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < size; i++){
            if(lenLIS[i] > max)
                max = lenLIS[i];
        }
        return max;


    }
};
