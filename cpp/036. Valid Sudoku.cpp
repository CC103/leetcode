#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	bool isValidRow(vector<char> v){
		int hash[10] = { 0 };
		for (int i = 0; i < 9; i++){
			if (v[i] >= '1' && v[i] <= '9'){
				if (hash[v[i] - 49] == 1)
					return false;
				hash[v[i] - 49] = 1;
				continue;
			}
			else if (v[i] == 46)
				continue;
			else{
				return false;
			}
		}
		return true;
	}
	bool isValidSudoku(vector<vector<char>>& board) {
		bool valid = true;
		for (int i = 0; i < 9; i++){
			if (valid == false)
				return false;
			valid = isValidRow(board[i]);
		}
		for (int i = 0; i < 9; i++){
			if (valid == false)
				return false;
			vector<char> column;
			for (int j = 0; j < 9; j++){
				column.push_back(board[j][i]);
			}
			valid = isValidRow(column);
		}
		for (int i = 0; i < 9; i++){
			if (valid == false)
				return false;
			vector<char>box = { board[i / 3 * 3][3 * (i % 3)], board[i / 3 * 3][3 * (i % 3) + 1], board[i / 3 * 3][3 * (i % 3) + 2], board[i / 3 * 3 + 1][3 * (i % 3)], board[i / 3 * 3 + 1][3 * (i % 3) + 1], board[i / 3 * 3 + 1][3 * (i % 3) + 2], board[i / 3 * 3 + 2][3 * (i % 3)], board[i / 3 * 3 + 2][3 * (i % 3) + 1], board[i / 3 * 3 + 2][3 * (i % 3) + 2] };
			valid = isValidRow(box);
		}
		return valid;
	}
};

int main(){
	vector<char> v1 = { '.', '.', '.', '.', '.', '.', '5', '.', '.' };
	vector<char> v2 = { '.', '.', '.', '.', '.', '.', '.', '.', '.' };
	vector<char> v3 = { '.', '.', '.', '.', '.', '.', '.', '.', '3' };
	vector<char> v4 = { '.', '2', '.', '7', '.', '.', '.', '.', '.' };
	vector<char> v5 = { '8', '3', '6', '5', '.', '.', '.', '.', '1' };
	vector<char> v6 = { '.', '.', '.', '.', '.', '1', '.', '.', '.' };
	vector<char> v7 = { '2', '.', '.', '.', '.', '.', '.', '.', '5' };
	vector<char> v8 = { '.', '.', '.', '.', '.', '.', '.', '.', '7' };
	vector<char> v9 = { '.', '.', '.', '4', '.', '.', '.', '7', '.' };
	vector<vector<char>> v = { v1, v2, v3, v4, v5, v6, v7, v8, v9 };
	Solution s;
	vector<char> test = { '1', '2', '3', '4', '5', '6', '7', '.', '7' };
	cout << s.isValidSudoku(v);
	system("pause");
	return 0;
}
