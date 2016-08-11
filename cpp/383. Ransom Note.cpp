class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        for(auto c : ransomNote){
            bool isFind = false;
            for(int i = 0; i < magazine.size(); i++){
                if(c == magazine[i]){
                    isFind = true;
                    magazine[i] = '*';
                    break;
                }
            }
            if(!isFind)
                return false;
        }
        return true;
        
    }
};
