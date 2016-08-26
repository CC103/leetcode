class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ret;
        map<int, int> m;
        map<int, int>::iterator it;
        int hash;
        for(int i = 0; i < int(s.size()) - 9; i++){
            hash = 0;
            string subString = s.substr(i, 10);
            for(auto c : subString){
                hash = hash << 2;
                //A-0; C-1; G-2; T-3
                if(c == 'C')
                    hash += 1;
                else if(c == 'G')
                    hash += 2;
                else if(c == 'T')
                    hash += 3;
            }
            it = m.find(hash);
            if(it == m.end())
                m[hash] = 1;
            else if(it->second == 1){
                ret.push_back(subString);
                it->second++;
            }
        }   
        return ret;
    }
};
