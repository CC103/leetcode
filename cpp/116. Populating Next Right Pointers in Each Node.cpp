class Solution {
public:
    void connect(TreeLinkNode *root) {
    	if(root == NULL)
    		return;
    	TreeLinkNode *pre;
    	TreeLinkNode *cur;
    	pre = root;
    	//we don't need traversal leaves level 
    	while(pre->left){
    		cur = pre;
    		//Make nodes in next level linked one by one
    		while(cur){
    			cur->left->next = cur->right;
    			if(cur->next)
    				cur->right->next = cur->next->left;
    			//Nodes in this level has been linked, so we can traversal this level by 'next'
    			cur = cur->next;
    		}
    		pre = pre->left;
    	}
    }
};
