/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    BSTIterator(TreeNode *root) {
    	sort(root);
    }
    void sort(TreeNode *root){
    	if(root == NULL)
    		return;
    	sort(root->left);
    	vec.push_back(root->val);
    	sort(root->right);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
    	if(index < vec.size())
    		return true;
        return false;
    }

    /** @return the next smallest number */
    int next() {
    	index++;
        return vec[index - 1];
    }
public:
	vector<int> vec;
	int index = 0;
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
