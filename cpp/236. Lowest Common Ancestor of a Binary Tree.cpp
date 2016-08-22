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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path1;
        vector<TreeNode*> path2;
        depFirSearch(p, root, path1);
        depFirSearch(q, root, path2);
        int min = path1.size() < path2.size() ? path1.size() : path2.size();
        int i;
        for(i = 0; i < min; i++){
            if(path1[i]->val != path2[i]->val)
                return path1[i - 1];
        }
        return path1[i - 1];
    }
    void depFirSearch(TreeNode *target, TreeNode *cur, vector<TreeNode*> &v){
        v.push_back(cur);
        if(cur == target)
            return;
        if(cur->left != NULL){
            depFirSearch(target, cur->left, v);
            v.pop_back();
        }
        if(cur->right != NULL){
            depFirSearch(target, cur->right, v);
            v.pop_back();
        }
    }
};
