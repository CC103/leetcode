class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        if(A.empty())
            return 0;
        int max = INT_MIN;
        int size = A.size();
        int sum = 0;
        int powerSum = 0;
        for(int i = 0; i < size; i++){
            sum += A[i];
            powerSum += A[i] * i;
        }
        for(int i = 0; i < size; i++){
            powerSum -= sum;
            powerSum += A[i] * size;
            max = max > powerSum ? max : powerSum;
        }
        return max;
    }
};
