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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    	vector<vector<int>> vectors;
    	int flag = 1; 
    	vector<stack<TreeNode*>> stacks;
    	if(root == NULL)
    		return vectors;
    	//initialization
    	stack<TreeNode*> s;
    	s.push(root);
    	stacks.push_back(s);

    	for(int i = 0; i < stacks.size(); i++, flag++){
    		//zigzag
    		flag = flag % 2;
    		//containers for saving data of i level
    		vector<int> v;
    		stack<TreeNode*> nextStack;
    		if(flag == 1){
    			while(!stacks[i].empty()){
    				TreeNode* p = stacks[i].top();
    				v.push_back(p->val);
    				if(p->left != NULL)
    					nextStack.push(p->left);
    				if(p->right != NULL)
    					nextStack.push(p->right);
    				stacks[i].pop();
    			}
    		}
    		else if(flag == 0){
    			while(!stacks[i].empty()){
    				TreeNode* p = stacks[i].top();
    				v.push_back(p->val);
    				if(p->right != NULL)
    					nextStack.push(p->right);
    				if(p->left != NULL)
    					nextStack.push(p->left);
    				stacks[i].pop();
    			}

    		}
    		if(!nextStack.empty()){
    			stacks.push_back(nextStack);
    		}
    		vectors.push_back(v);
    	}
    	return vectors;
    }
};
