class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> hashS(256, 0), hashP(256, 0);
        vector<int> ret;
        if(p.size() > s.size()) return ret;
        for(int i = 0; i < p.size(); i++){
            hashP[p[i]]++;
            hashS[s[i]]++;
        }
        if(hashS == hashP){
            ret.push_back(0);
        }
        for(int i = p.size(); i < s.size(); i++){
            hashS[s[i]]++;
            hashS[s[i - p.size()]]--;
            if(hashS == hashP){
                ret.push_back(i - p.size() + 1);
            }
        }
        return ret;
    }
};
