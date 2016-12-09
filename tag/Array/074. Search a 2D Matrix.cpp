class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
    	if(matrix.empty()) return false;
    	int row = matrix.size();
    	int col = matrix[0].size();
    	int start = 0, end = row * col - 1, mid;
    	while (start <= end) {
    		mid = (start + end) / 2;
    		if (matrix[mid / col][mid % col] == target) return true;
    		else if (matrix[mid / col][mid % col] > target) {
    			end = mid - 1;
    		}
    		else {
    			start = mid + 1;
    		}
    	}
    	return false;
    }
};