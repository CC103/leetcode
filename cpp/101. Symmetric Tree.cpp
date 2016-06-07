#include<iostream>
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
	bool mirrorTree(TreeNode* p, TreeNode* q){
		if (p == NULL && q == NULL)
			return true;
		if (p != NULL && q != NULL && p->val == q->val){
			return mirrorTree(p->left, q->right) && mirrorTree(p->right, q->left);
		}
		return false;
	}
	bool isSymmetric(TreeNode* root) {
		if (root == NULL)
			return true;
		return mirrorTree(root->left, root->right);

	}
};
