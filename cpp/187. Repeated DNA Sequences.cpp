class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> subStrings;
        vector<string> ret;
        map<int, int> m;
        cout << "start";
        for(int i = 0; i < int(s.size()) - 9; i++){
            subStrings.push_back(s.substr(i, 10));
        }   
        int hash;
        map<int, int>::iterator it;
        for(auto i : subStrings){
            hash = 0;
            for(auto j : i){
                //make sure that each char could occupy unique position 
                hash = hash << 2;
                //A-0; C-1; G-2; T-3
                if(j == 'C')
                    hash += 1;
                else if(j == 'G')
                    hash += 2;
                else if(j == 'T')
                    hash += 3;
            }
            cout << i << ": " << hash << endl;
            it = m.find(hash);
            if(it == m.end())
                m[hash] = 1;
            else if(it->second == 1){
                ret.push_back(i);
                it->second++;
            }
        }
        return ret;
    }
};
