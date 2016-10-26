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
    int pathSum(TreeNode* root, int sum) {
        if(!root) return 0;
        return pathSumWithRoot(root, 0, sum) + pathSum(root->left, sum) + pathSum(root->right, sum);
    }
private:
    int pathSumWithRoot(TreeNode* root, int pre, int &sum){
        if(!root) return 0;
        int current = pre + root->val;
        return (current == sum) + pathSumWithRoot(root->left, current, sum) + pathSumWithRoot(root->right, current, sum);
    }
};
