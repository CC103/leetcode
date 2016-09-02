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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
         unordered_map<int, int> inorderMap;
         for(int i = 0; i < inorder.size(); i++){
            inorderMap[inorder[i]] = i;
         }
         return build(preorder, 0, preorder.size() - 1, 0, inorder.size() - 1, inorderMap);

    }
    TreeNode* build(vector<int>& preorder, int preStart, int preEnd, int inStart, int inEnd, unordered_map<int, int>& inorderMap){
        if(preStart > preEnd || inStart > inEnd)
            return NULL;
        TreeNode *root = new TreeNode(preorder[preStart]);
        int pos = inorderMap.find(preorder[preStart])->second;
        int len = pos - inStart;
        root->left = build(preorder, preStart + 1, preStart + len, inStart, pos - 1, inorderMap);
        root->right = build(preorder, preStart + len + 1, preEnd, pos + 1, inEnd, inorderMap);
        return root;
    }
};
