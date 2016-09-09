class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ret;
        if(nums.empty())
            return ret;
        sort(nums.begin(), nums.end());
        int target, front, back;
        for(int i = 0; i < nums.size(); i++){
            target = -nums[i];
            front = i + 1;
            back = nums.size() - 1;
            while(front < back){
                int sum = nums[front] + nums[back];
                if(sum > target)
                    back--;
                else if(sum < target)
                    front++;
                else{
                    vector<int> v(3);
                    v[0] = nums[i];
                    v[1] = nums[front];
                    v[2] = nums[back];
                    ret.push_back(v);
                    while(front < back && nums[front] == v[1])
                        front++;
                    while(front < back && nums[back] == v[2])
                        back--;
                }
            }
            while(nums[i + 1] == nums[i])
                i++;
        }
        return ret;
    }
};
