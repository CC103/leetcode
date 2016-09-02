class Solution {
public:
    int mySqrt(int x) {
        int start = 0;
        int end = x;
        while(start < end){
            int mid = (start + end + 1) / 2;
            cout << start << " " << mid << " " << end <<endl;
            long int mul = mid * mid;
            if(mul == x)
                return mid;
            if(mul > x){
                end = mid - 1;
            }
            else
                start = mid;
        }
        return start;
    }
};
