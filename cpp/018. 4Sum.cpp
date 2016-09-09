class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> ret;
        if(nums.empty())
            return ret;
        sort(nums.begin(), nums.end());
        int size = nums.size();
        int firTarget, secTarget, front, back, sum;
        for(int i = 0; i < size; i++){
            firTarget = target - nums[i];
            for(int j = i + 1; j < size; j++){
                secTarget = firTarget - nums[j];
                front = j + 1;
                back = size - 1;
                while(front < back){
                    sum = nums[front] + nums[back];
                    if(sum < secTarget)
                        front++;
                    else if(sum > secTarget)
                        back--;
                    else{
                        vector<int> solution(4);
                        solution[0] = nums[i];
                        solution[1] = nums[j];
                        solution[2] = nums[front];
                        solution[3] = nums[back];
                        ret.push_back(solution);
                        while(front < back && nums[front] == solution[2])
                            front++;
                        while(front < back && nums[back] == solution[3])
                            back--;
                    }
                }
                // all solutions whose first element is nums[i] and second element is nums[j] have been put into ret
                // so we need a new second element
                while(nums[j + 1] == nums[j])
                    j++;
            }
            while(nums[i + 1] == nums[i])
                i++;
        }
        return ret;
    }
};
