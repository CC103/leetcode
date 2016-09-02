class Solution {
public:
    int mySqrt(int x) {
        int start = 0;
        int end = x < INT_MAX ? x : INT_MAX;
        while(start < end){
            int mid = (start + end + 1) / 2;
            //cout << start << " " << mid << " " << end <<endl;
            
            if(mid == x / mid)
                return mid;
            if(mid > x / mid){
                end = mid - 1;
            }
            else
                start = mid;
        }
        return start;
    }
};
