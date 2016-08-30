class Solution {
public:
    int firstUniqChar(string s) {
        int size = s.size();
        int index = -1;
        for(int i = 0; i < size; i++){
            bool isRepeated = false;
            for(int j = 0; j < size; j++){
                if(j == i)
                    continue;
                if(s[i] == s[j]){
                    isRepeated = true;
                    break;
                }
            }
            if(!isRepeated){
                index = i;
                break;
            }
        }
        return index;
    }
};
