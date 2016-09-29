class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> strArray;
        for(auto i : nums){
            strArray.push_back(to_string(i));
        }
        sort(strArray.begin(), strArray.end(), [](string str1, string str2){
            return str1 + str2 > str2 + str1;
        });
        string ret;
        for(auto i : strArray){
            ret += i;
        }
        while(ret[0] == '0' && ret.size() > 1){
            ret.erase(0,1);
        }
        return ret;
    }
};
