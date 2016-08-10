// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        int left = 1, right = n;
        int mid;
        while(left < right){
            int mid = left + (right - left) / 2;
            int flag = guess(mid);
            if(flag == 0)
                return mid;
            if(flag == -1)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
        
    }
};
