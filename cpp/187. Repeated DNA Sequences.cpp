class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ret;
        int hashTable[1048576] = {0};
        int hash = 0;
        char c;
        if(s.size() < 11)
            return ret;
        //initialization 
        for(int i = 0; i < 9; i++){
            hash = hash << 2;
            c = s[i];
            if(c == 'C')
                hash += 1;
            else if(c == 'G')
                hash += 2;
            else if(c == 'T')
                hash += 3;
        }
        for(int i = 9; i < s.size(); i++){
            hash = hash << 2;
            c = s[i];
            if(c == 'C')
                hash += 1;
            else if(c == 'G')
                hash += 2;
            else if(c == 'T')
                hash += 3;
            //remove the higher(more than 20) bits
            hash = hash & 0xfffff;
            if(hashTable[hash]++ == 1){
                ret.push_back(s.substr(i - 9, 10));
            }
        }
        return ret;
    }
};
