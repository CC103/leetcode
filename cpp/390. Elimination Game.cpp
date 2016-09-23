class Solution {
public:
    int lastRemaining(int n) {
        return leftToRight(n);

    }
    int leftToRight(int n){
        if(n <= 2){
            return n;
        }
        else{
            return 2 * rightToRight(n / 2);
        }
    }
    int rightToRight(int n){
        if(n <= 2){
            return 1;
        }
        else{
            if(n % 2 == 1){
                return 2 * leftToRight(n / 2);
            }
            else{
                // 1, 3 (+1) -> 2, 4 (/2) -> 1, 2
                // we need  multiple 2 first and then minus 1 to get true value 
                return 2 * leftToRight(n / 2) - 1;
            }
        }
        
    }
};
