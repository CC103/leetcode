class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
    	int row = -1;
    	if(target < matrix[0][0])
    		return false;
    	for(int i = 0; i < matrix.size() - 1; i++){
    		if(target >= matrix[i][0] && target < matrix[i + 1][0]){
    			row = i;
    			break;
    		}
    	}
    	if(row == -1){
    		row = matrix.size() - 1;
    	}
    	return binarySearch(matrix[row], target);
        
    }

    bool binarySearch(vector<int> row, int target){
    	int size = row.size();
    	int start = 0, end = size - 1;
    	while(start <= end){
    		int mid = (start + end) / 2;
    		if(row[mid] == target)
    			return true;
    		else if(row[mid] < target){
    			start = mid + 1;
    		}
    		else
    			end = mid - 1;
    	}
    	return false;

    }
};
