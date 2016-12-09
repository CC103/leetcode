class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
    	if(matrix.empty()) return false;
        int len = matrix[0].size();
        int start = 0, end = matrix.size() - 1, mid;
        while (start <= end) {
        	mid = (start + end) / 2;
        	if (target >= matrix[mid][0] && target <= matrix[mid][len - 1]) {
        		int fir = 0, thir = len - 1, sec;
        		while (fir <= thir) {
        			sec = (fir + thir) / 2;
        			if (target == matrix[mid][sec]) return true;
        			else{
        				if (target > matrix[mid][sec]) {
        					fir = sec + 1;
        				}
        				else {
        					thir = sec - 1;
        				}
        			}
        		}
        		return false;
        	}
        	else {
        		if (target > matrix[mid][len - 1]) {
        			start = mid + 1;
        		}
        		else if (target < matrix[mid][0]) {
        			end = mid - 1;
        		}
        	}
        }
        return false;
    }
};