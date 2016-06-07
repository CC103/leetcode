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
	void minD(TreeNode* node, int& depth, int& min){
		depth++;
		if (node->left == NULL && node->right == NULL){
			if (depth < min)
				min = depth;
		}
		else{
			if (node->left != NULL){
				minD(node->left, depth, min);
				depth--;
			}
			if (node->right != NULL){
				minD(node->right, depth, min);
				depth--;
			}
		}
		return;
	}
	int minDepth(TreeNode* root) {
		if (root == NULL)
			return 0;
		int min = 10000;
		int depth = 0;
		minD(root, depth, min);
		return min;
	}
};
int main(){
	TreeNode t1(1);
	TreeNode t2(2);
	TreeNode t3(3);
	TreeNode t4(4);
	TreeNode t5(5);
	TreeNode t6(6);
	TreeNode t7(7);
	TreeNode t8(8);
	t1.right = &t2;
	t1.left = &t3;
	t3.left = &t4;
	t3.right = &t5;
	t4.left = &t8;
	t2.right = &t6;
	t6.right = &t7;
	Solution s;
	cout << s.minDepth(&t1);
	system("pause");
	return 0;
}
