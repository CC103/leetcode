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
    void flatten(TreeNode* root) {
        vector<int> arr;
        dfSearch(root, arr);
        TreeNode* last = new TreeNode(0);
        TreeNode* head = last;
        for(int i : arr){
        	TreeNode node(i);
        	last->next = &node;
        	last = last->next; 
        }
        root = head->next;
    }
    void dfSearch(TreeNode* root, vector<int> &arr){
    	arr.push_back(root->val);
    	if(root->left != NULL)
    		dfSearch(root->left, arr);
    	if(root->right != NULL)
    		dfSearch(root->right, arr);
    }
};
