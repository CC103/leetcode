class Solution {
    public:
        vector<vector<int> > generateMatrix(int n) {
            vector<vector<int>> ret(n, vector<int>(n));
            int k = 1; 
            //i is the most important var here
            //i represents the matrix to be calculated is becoming smaller
            int i = 0;
            while(k <= n * n){
            	int j = i;
            	//four steps
            	//Horizonal, left to right
            	while(j < n - i){
            		ret[i][j++] = k++;
            	}
            	//Vertical, top to bottom
            	j = i + 1;
            	while(j < n - i){
            		ret[j++][n - 1 - i] = k++;
            	}
            	//Horizonal, right to left
            	j = n - 2 - i;
            	while(j > i){
            		ret[n - 1 - i][j--] = k++;
            	}
            	//Vertical, bottom to top
            	j = n - 1 - i;
            	while(j > i){
            		ret[j--][i] == k++;
            	}
            	i++;
            }
            return ret;
        }
    };
