
#include<iostream>
 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	void search(TreeNode* root, int sum, int pathSum, int& flag){
		if (flag == 1)
			return;
		pathSum += root->val;
		if (root->left == NULL && root->right == NULL){
			if (pathSum == sum)
				flag = 1;
		}
		else{
			if (root->left != NULL)
				search(root->left, sum, pathSum, flag);
			if (root->right != NULL)
				search(root->right, sum, pathSum, flag);
		}
		return;
	}
	bool hasPathSum(TreeNode* root, int sum) {
		int flag = 0;
		int pathSum = 0;
		if (root == NULL)
			return false;
		search(root, sum, pathSum, flag);
		if (flag == 1)
			return true;
		return false;
	}
};
