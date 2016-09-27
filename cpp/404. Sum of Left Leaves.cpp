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
    int sumOfLeftLeaves(TreeNode* root) {
        queue<TreeNode*> nodesQueue;
        int sum = 0;
        if(root != NULL){
            nodesQueue.push(root);
        }
        else return 0;
        while(!nodesQueue.empty()){
            TreeNode *temp = nodesQueue.front();
            nodesQueue.pop();
            TreeNode *left = temp->left;
            TreeNode *right = temp->right;
            if(left != NULL){
                if(left->left == NULL && left->right == NULL){
                    sum += left->val;
                }
                else{
                    nodesQueue.push(left);
                }
            }
            if(right != NULL){
                if(right->left != NULL || right->right != NULL){
                    nodesQueue.push(right);
                }
            }
        }
        return sum;
    }
};
