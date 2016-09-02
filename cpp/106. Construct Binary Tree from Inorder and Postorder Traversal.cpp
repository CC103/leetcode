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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int, int> m;
        for(int i = 0; i < inorder.size(); i++){
            m[inorder[i]] = i;
        }
        return build(postorder, 0, postorder.size() - 1, 0, inorder.size() - 1, m);

    }
    TreeNode* build(vector<int>& postorder, int pstart, int pend, int istart, int iend, unordered_map<int, int> &m){
        //cout << pstart << " " << pend << " " << istart << " " << iend << endl;
        if(istart > iend || pstart > pend)
            return NULL;
        int rootVal = postorder[pend];
        TreeNode *root = new TreeNode(rootVal);
        int pos = m.find(rootVal)->second;
        //cout << pos << endl;
        int len = pos - istart;
        root->left = build(postorder, pstart, pstart + len - 1, istart, istart + len - 1, m);
        root->right = build(postorder, pstart + len, pend - 1, pos + 1, iend, m);
        return root;
    }
};
