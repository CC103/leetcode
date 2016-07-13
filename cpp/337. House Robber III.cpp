	#include <iostream>
	using namespace std;	
		/*
		* Definition for a binary tree node.
		* struct TreeNode {
		*     int val;
		*     TreeNode *left;
		*     TreeNode *right;
		*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
		* };
		*/
	class Solution {
		public:
		int rob(TreeNode* root) {
			if(root == NULL)
				return 0;
			if(root->left == NULL && root->right == NULL)
				return root->val;
			int robHere;
			int notRob;
			notRob = rob(root->left) + rob(root->right);
			if(root->left != NULL && root->right != NULL){
				robHere = root->val + rob(root->left->left) + rob(root->left->right);
				//this line is too long so I cut it off
				robHere += rob(root->right->left) + rob(root->right->right);
			}
			else if(root->left == NULL){
				robHere = root->val + rob(root->right->left) + rob(root->right->right);
			}
			else{
				robHere = root->val + rob(root->left->left) + rob(root->left->right);
			}
			return (robHere > notRob) ? robHere : notRob;

		}
	};
