#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;

 struct TreeNode {
    int val;
	TreeNode *left;
	TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	vector<vector<int>> levelOrderBottom(TreeNode* root) {
		vector<TreeNode*> vecNode;
		vector<vector<int>> vecNum;
		if (root == NULL)
			return vecNum;
		vecNode.push_back(root);
		int cur = 0;
		int last = 1;
		int level = 0;
		while (cur < vecNode.size()){
			last = vecNode.size();
			vector<int> tmp;
			vecNum.push_back(tmp);
			cout << vecNum.size();
			while (cur < last){
				if (vecNode[cur]->left != NULL)
					vecNode.push_back(vecNode[cur]->left);
				if (vecNode[cur]->right != NULL)
					vecNode.push_back(vecNode[cur]->right);
				vecNum[level].push_back(vecNode[cur]->val);
				cur++;
			}
			level++;
		}
		vector<vector<int>> res;
		for (int i = 0; i < vecNum.size(); i++){
			vector<int> tmp;
			res.push_back(tmp);
			res[i] = vecNum[vecNum.size() - 1 - i];
		}
		return res;
	}
};

int main(){
	TreeNode* root = new TreeNode(0);
	Solution s;
	s.levelOrderBottom(root);
	system("pause");
	return 0;
}
