class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<pair<int, int>> newNums;
        int maxNum = INT_MIN;
        for(int i = 0; i < nums.size(); i++){
            maxNum = max(maxNum, nums[i]);
            pair<int, int> p(nums[i], i);
            newNums.push_back(p);
        }
        int digits = 1;
        while(maxNum){
            maxNum /= 10;
            digits *= 10;
        }
        int lowBound = digits / 10;
        for(int i = 0; i < newNums.size(); i++){
            while(newNums[i].first < lowBound){
                newNums[i].first = newNums[i].first * 10 + newNums[i].first - newNums[i].first / 10 * 10;
            }
        }
        sort(newNums.begin(), newNums.end(),[](pair<int, int> p, pair<int, int> q){
            return p.first > q.first;
        });
        stringstream ss;
        string ret = "";
        for(auto i : newNums){
            string str;
            ss << nums[i.second];
            ss >> str;
            ret += str;
            ss.clear();
            ss.str("");
        }
        return ret;
    }
};
