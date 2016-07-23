class Solution {
public:
    void connect(TreeLinkNode *root) {
    	if(root == NULL)
    		return;
    	vector<vector<TreeLinkNode*>> vecByLevel;
    	//Put root into first level vector
    	vector<TreeLinkNode*> level_0;
    	level_0.push_back(root);
    	vecByLevel.push_back(level_0);
    	//put nodes into vector grouped by level
    	for(int i = 0; i <= vecByLevel.size(); i++){
    		vector<TreeLinkNode*> nextLevel;
    		for(int j = 0; j < vecByLevel[i].size(); j++){
    			TreeLinkNode* p = vecByLevel[i][j];
    			//The tree is perfect, left and right exist in the same time 
    			if(p->left != NULL){
    				nextLevel.push_back(p->left);
    				nextLevel.push_back(p->right);
    			}
    			//The tree is perfect, only leaves don't have child
    			else
    				break;
    		}
    		if(!nextLevel.empty())
    			vecByLevel.push_back(nextLevel);
    	}

    	for(int i = 0; i < vecByLevel.size(); i++){
    		for(int j = 0; j < vecByLevel[i].size() - 1; j++){
    			vecByLevel[i][j]->next = vecByLevel[i][j + 1];
    		}
    	}
    }
};
