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
        if(root == NULL)
            return;
        vector<int> arr;
        dfSearch(root, arr);
        TreeNode* cur = new TreeNode(0);
        TreeNode* head = cur;
        for(int i : arr){
            cur->right = new TreeNode(i);
            cur->left = NULL;
            cur = cur->right;
        }
        *root = *(head->right);
        cout << endl;
    }
    void dfSearch(TreeNode* root, vector<int> &arr){
    	arr.push_back(root->val);
    	if(root->left != NULL)
    		dfSearch(root->left, arr);
    	if(root->right != NULL)
    		dfSearch(root->right, arr);
    }
};
