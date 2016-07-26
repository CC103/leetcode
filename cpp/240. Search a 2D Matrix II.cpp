/*
以每个矩形的右上角元素作为middle，左移抛弃的都是比middle大的元素，下移抛弃的都是比middle小的元素
*/
class Solution {
public:
bool searchMatrix(vector<vector<int>>& matrix, int target) {
    int m = matrix.size();
    int n = matrix[0].size();
    int row = 0;
    int column = n - 1;
    while(row < m && column >= 0){
        if(target == matrix[row][column])
            return true;
        else if(target < matrix[row][column]){
            //target is smaller，move left，abandon elements larger than middle
            column--;
        }
        else{
            //target is bigger, move down, abandon elements smaller than middle
            row++;
        }
    }
    return false;
}
};
