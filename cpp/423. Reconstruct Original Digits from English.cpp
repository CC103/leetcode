class Solution {
public:
    string originalDigits(string s) {
        int hash[26] = {0};
        vector<int> ret;
        for(auto c : s){
            hash[c - 'a']++;
        }
        while(hash['z' - 'a']--){
            hash['e' - 'a']--;
            hash['r' - 'a']--;
            hash['o' - 'a']--;
            ret.push_back(0);
        }
        while(hash['g' - 'a']--){
            hash['i' - 'a']--;
            hash['e' - 'a']--;
            hash['h' - 'a']--;
            hash['t' - 'a']--;
            ret.push_back(8);
        }
        while(hash['x' - 'a']--){
            hash['s' - 'a']--;
            hash['i' - 'a']--;
            ret.push_back(6);
        }
        while(hash['w' - 'a']--){
            hash['t' - 'a']--;
            hash['o' - 'a']--;
            ret.push_back(2);
        }
        while(hash['u' - 'a']--){
            hash['f' - 'a']--;
            hash['o' - 'a']--;
            hash['r' - 'a']--;
            ret.push_back(4);
        }
        while(hash['s' - 'a']--){
            hash['e' - 'a'] -= 2;
            hash['v' - 'a']--;
            hash['n' - 'a']--;
            ret.push_back(7);
        }
        while(hash['t' - 'a']--){
            hash['e' - 'a'] -= 2;
            hash['h' - 'a']--;
            hash['r' - 'a']--;
            ret.push_back(3);
        }
        while(hash['f' - 'a']--){
            hash['e' - 'a'] --;
            hash['v' - 'a']--;
            hash['i' - 'a']--;
            ret.push_back(5);
        }
        while(hash['o' - 'a']--){
            hash['e' - 'a'] --;
            hash['n' - 'a']--;
            ret.push_back(1);
        }
        while(hash['i' - 'a']--){
            ret.push_back(9);
        }
        sort(ret.begin(), ret.end());
        string str;
        for(auto n : ret){
            str += to_string(n);
        }
        return str;

    }
};
