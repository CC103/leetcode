#include<iostream>
#include<vector>
using namespace std;

 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	vector<vector<int>> levelOrder(TreeNode* root) {
		vector<TreeNode*> vNode;
		vector<vector<int>> vNum;
		if (root == NULL)
			return vNum;
		vNode.push_back(root);
		int cur = 0;
		int last = 1;
		int level = 0;
		while (cur < vNode.size()){
			vector<int> v;
			vNum.push_back(v);
			while (cur < last){
				if (vNode[cur]->left != NULL)
					vNode.push_back(vNode[cur]->left);
				if (vNode[cur]->right != NULL)
					vNode.push_back(vNode[cur]->right);
				vNum[level].push_back(vNode[cur]->val);
				cur++;
			}
			level++;
			last = vNode.size();
		}
		return vNum;
	}
};
