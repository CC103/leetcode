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
    int countNodes(TreeNode* root) {
        if(!root)
            return 0;
        int l = 0, r = 0;
        TreeNode *left = root;
        TreeNode *right = root;
        while(left){
            l++;
            left = left->left;
        }
        while(right){
            r++;
            right = right->right;
        }
        if(l == r)
            return pow(2, l) - 1;
        else
            return 1 + countNodes(root->left) + countNodes(root->right);
    }
};
