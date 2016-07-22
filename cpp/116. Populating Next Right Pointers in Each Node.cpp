class Solution {
public:
    void connect(TreeLinkNode *root) {
    	vector<vector<TreeNode*>> vecByLevel;
    	int i = 0;
    	vector<TreeNode*> level0;
    	level0.push_back(root);
    	vecByLevel.push_back(level0);
    	for(int i = 0; i <= vecByLevel.size(); i++){
    		vector<TreeNode*> nextLevel;
    		for(int j = 0; j < vecByLevel[i].size(); j++){
    			TreeNode* p = vecByLevel[i][j];
    			//The tree is perfect 
    			if(p->left != NULL){
    				nextLevel.push_back(p->left);
    				nextLevel.push_back(p->right);
    			}

    		}

    	}

        
    }
};
