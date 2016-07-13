#include<iostream>
#include<queue>
using namespace std;
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
    void sortVal(TreeNode* root, queue<int>& q){
        if(root->left != NULL){
            sortVal(root->left, q);
        }
        q.push(root->val);
        if(root->right != NULL){
            sortVal(root->right, q);
        }
    }
    int kthSmallest(TreeNode* root, int k) {
        if(root == NULL)
            return 0;
        queue<int> q;
        sortVal(root, q);
        int ret;
        while(k){
            ret = q.front();
            q.pop();
            k--;
        }
        return ret;
        
    }
};
