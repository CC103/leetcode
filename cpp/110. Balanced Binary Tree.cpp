#include<iostream>

 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	bool isB(TreeNode* root, int *depth){
		if (root == NULL){
			*depth = 0;
			return true;
		}
		int leftDep, rightDep;
		bool isLeft = isB(root->left, &leftDep);
		bool isRight = isB(root->right, &rightDep);
		if (isLeft && isRight){
			int diff = (leftDep > rightDep) ? (leftDep - rightDep) : (rightDep - leftDep);
			if (diff <= 1){
				*depth = (leftDep > rightDep) ? (leftDep + 1) : (rightDep + 1);
				return true;
			}
		}
		return false;
	}
	bool isBalanced(TreeNode* root) {
		int depth;
		return isB(root, &depth);
	}
};
