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
	void searchPath(int value, int *p, TreeNode* root){
		if (root->val == value){
			*p = root->val;
			return;
		}
		if (root->val > value){
			*p = root->val;
			p++;
			searchPath(value, p, root->left);
		}
		else{
			*p = root->val;
			p++;
			searchPath(value, p, root->right);
		}
	}
	TreeNode* search(TreeNode* root, int value){
		TreeNode* node = root;
		int found = 0;
		while (node != NULL){
			if (node->val == value){
				found = 1;
				break;
			}
			node = (value > node->val) ? node->right : node->left;
		}
		return found ? node : NULL;
	}
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		int pval = p->val;
		int qval = q->val;
		int pathArrP[1000] = { -1 };
		int pathArrQ[1000] = { -1 };
		searchPath(pval, pathArrP, root);
		searchPath(qval, pathArrQ, root);
		int lcaVal;
		for (int i = 0; i < 1000; i++){
			if (pathArrP[i] != pathArrQ[i]){
				lcaVal = pathArrP[i - 1];
				break;
			}
		}
		TreeNode* lca = search(root, lcaVal);
		return lca;
	}
};
int main(){
	TreeNode n1(1);
	TreeNode n2(2);
	TreeNode n3(3);
	TreeNode n4(4);
	TreeNode n5(5);
	TreeNode n6(6);
	n5.left = &n3;
	n5.right = &n6;
	n3.left = &n2;
	n3.right = &n4;
	n2.left = &n1;
	Solution s;
	TreeNode *lca = s.lowestCommonAncestor(&n5, &n1, &n6);
	cout << lca->val;
	system("pause");
	return 0;
}
