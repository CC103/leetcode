class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int start = 0;
        int end = 0;
        stringstream ss;
        vector<string> ret;
        if(nums.empty())
            return ret;
        while(start < nums.size()){
            if(end + 1 < nums.size() && nums[end + 1] == nums[end] + 1){
                end++;
            }
            else{
                string s, startStr, endStr;
                if(start == end){
                    ss << nums[start];
                    ss >> s;
                    ss.clear();
                    ss.str("");
                }
                else{
                    ss << nums[start];
                    ss >> startStr;
                    ss.clear();
                    ss.str("");
                    ss << nums[end];
                    ss >> endStr;
                    ss.clear();
                    ss.str("");
                    s = startStr + "->" + endStr;
                }
                ret.push_back(s);
                start = 1 + end++;
            }
        }
        return ret;
    }
};
