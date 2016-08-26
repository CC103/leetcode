class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> subStrings;
        vector<string> ret;
        if(s.empty())
            return ret;
        for(int i = 0; i < int(s.size()) - 9; i++){
            subStrings.push_back(s.substr(i, 10));
        }   
        bool isRepeated;
        for(int i = 0; i < subStrings.size(); i++){
            isRepeated = false;
            if(!subStrings[i].empty()){
                for(int j = i + 1; j < subStrings.size(); j++){
                    if(subStrings[i] == subStrings[j]){
                        if(!isRepeated){
                            ret.push_back(subStrings[i]);
                            isRepeated = true;
                        }
                        subStrings[j] = "";
                    }
                }
            }
        }
        return ret;
    }
};
