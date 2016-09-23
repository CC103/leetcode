class Solution {
public:
    int lastRemaining(int n) {
        int *num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = i + 1;
        }
        while(n > 1){
            int size = n;
            n /= 2;
            int *leftToRight = new int[n];
            for(int i = 1, j = 0; i < size; i += 2, j++){
                leftToRight[j] = num[i];
            }
            delete num;
            if(n == 1){
                return leftToRight[0];
            }
            else{
                int size = n;
                n /= 2;
                int *rightToleft = new int[n];
                for(int i = size - 2, j = n - 1; i >= 0; i -= 2, j--){
                    rightToleft[j] = leftToRight[i];
                }
                delete leftToRight;
                if(n == 1){
                return rightToleft[0];
                }
                else{
                    num = rightToleft;
                }
            }
        }
        // initial n = 1
        return num[0];
    }
};
