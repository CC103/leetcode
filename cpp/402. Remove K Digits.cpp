class Solution {
public:
    string removeKdigits(string num, int k) {
        if(k >= num.size())
            return "0";
        remove(num, k, 0);
        while(num[0] == '0'){
            num.erase(num.begin());
        }
        if(num.empty()){
            return "0";
        }
        return num;
    }
    void remove(string &num, int k, int start){
        if(k == 0)
            return;
        int min = INT_MAX;
        int minIndex = -1;
        // find the smallest first number
        for(int i = start; i < k + 1 + start; i++){
            if(num[i] - '0' < min){
                min = num[i] - '0';
                minIndex = i;
            }
        }
        // number of elements which should be erased
        int m = minIndex - start;
        while(m){
            num.erase(num.begin() + start);
            k--;
            m--;
        }
        remove(num, k, start + 1);
    }
};
