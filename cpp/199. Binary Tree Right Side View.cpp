/**
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
    vector<int> rightSideView(TreeNode* root) {
        vector<vector<TreeNode*>> vecNodes;
        vector<int> ret;
        if(root == NULL)
        	return ret;
        vector<TreeNode*> firLevel;
        firLevel.push_back(root);
        vecNodes.push_back(firLevel);
        for(int i = 0; i < vecNodes.size(); i++){
        	vector<TreeNode*> nextLevel;
        	for(int j = 0; j < vecNodes[i].size(); j++){
        		TreeNode* p = vecNodes[i][j];
        		if(p->left != NULL){
        			nextLevel.push_back(p->left);
        		}
        		if(p->right != NULL){
        			nextLevel.push_back(p->right);
        		}
        	}
        	//All nodes have been saved
        	if(nextLevel.empty())
        		break;
        	vecNodes.push_back(nextLevel);
        }

        for(int i = 0; i < vecNodes.size(); i++){
        	//Find the last element of each level
        	int end = vecNodes[i].size() - 1;
        	ret.push_back(vecNodes[i][end]->val);
        }

        return ret;

    }
};
