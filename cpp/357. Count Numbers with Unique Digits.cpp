class Solution {
public:
    int cal(int n){
        if(n == 1){
            return 10;
        }
        int num = 1;
        while(n){
            if(n == 1){
                num *= 9;
            }
            else{
                num *= 9 - n + 2;
            }
            n--;
        }
        return num;
    }
    int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        int num = 0;
        while(n){
            num += cal(n);
            n--;
        }
        return num;
    }
};
