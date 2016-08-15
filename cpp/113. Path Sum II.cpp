
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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> paths;
        vector<int> path;
        int sum_ = 0;
        if(root == NULL)
            return paths;
        DFS(root, path, paths, sum_, sum);
        return paths;
    }

    void DFS(TreeNode *root, vector<int> &path, vector<vector<int>> &paths, int &sum, int target){
        sum += root->val;
        path.push_back(root->val);
        if(sum == target && root->left == NULL && root->right == NULL){
            paths.push_back(path);
            path.pop_back();
            sum -= root->val;
            return;
        }
        if(root->left != NULL)
            DFS(root->left, path, paths, sum, target);        
        if(root->right != NULL)
            DFS(root->right, path, paths, sum, target);
        path.pop_back();
        sum -= root->val;
        return;
    }
};
