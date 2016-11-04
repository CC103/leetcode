class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.size() < 3) return 0;
        vector<int> nums;
        int diff = A[1] - A[0];
        int num = 0;
        // num of arithmetic slices between (P, Q)
        for(int i = 2; i < A.size(); i++){
            if(A[i] - A[i - 1] == diff){
                num++;
            }
            else{
                if(num) nums.push_back(num);
                diff = A[i] - A[i - 1];
                num = 0;
            }
        }
        if(num) nums.push_back(num);
        int total = 0;
        for(auto n : nums){
            total += n * (n + 1) / 2;
        }
        return total;
    }
};
