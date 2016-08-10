class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while(start < end){
            int mid = (start + end) / 2;
            //save the number of elements which is smaller than mid
            int num = 0;            
            for(int i = 0; i < n; i++){
                int t = upper_bound(matrix[i].begin(), matrix[i].end(), mid) - matrix[i].begin();
                num += t;
            }
            if(num < k)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
};
