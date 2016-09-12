class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        if(A.empty())
            return 0;
        int max = INT_MIN;
        int size = A.size();
        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = 0; j < size; j++){
                sum += A[j] * ((j+i) % size);
            }
            max = sum > max ? sum : max;
        }
        return max;
    }
};
