class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> hash(26, 0);
        vector<int> ret;
        for(auto c : p){
            hash[c - 'a']++;
        }
        for(int i = 0; i < int(s.size()) - int(p.size()) + 1; i++){
            if(hash[s[i] - 'a'] == 0) continue;
            else{
                vector<int> tempHash(hash);
                bool isAnagrams = true;
                for(int j = i; j < i + p.size(); j++){
                    // normally, the hash[s[j] - 'a'] can not be smaller than zero
                    if(tempHash[s[j] - 'a'] <= 0){
                        isAnagrams = false;
                        break;
                    } 
                    else{
                        tempHash[s[j] - 'a']--;
                    }
                }
                if(isAnagrams){
                    ret.push_back(i);
                }
            }
        }
        return ret;
    }
};
