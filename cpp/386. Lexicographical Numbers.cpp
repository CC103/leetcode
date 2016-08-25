class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<int> ret;
        int i = 1;
        for(int j = 0; j < n; j++){
            ret.push_back(i);
            if(i * 10 <= n)
                i *= 10;
            else if(i % 10 != 9 && i + 1 <= n)
                i++;
            else{
                while((i / 10) % 10 == 9)
                    i /= 10;
                i = i / 10 + 1;
            }
        }
        return ret;
    }
};
