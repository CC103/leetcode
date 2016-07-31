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
    int sumNumbers(TreeNode* root) {
        if(root == NULL)
            return 0;
        vector<vector<int>> paths;
        vector<int> path;
        search(root, path, paths);
        int sum = 0;
        // for(auto i : paths){
        // 	for(auto j : i){
        // 		cout << j << ' ';
        // 	}
        // 	cout << endl;
        // }
        for(auto i : paths){
        	for(int j = 0; j < i.size(); j++){
        		sum += i[j] * pow(10, i.size() - j - 1);
        	}
        }
        return sum;
    }
    void search(TreeNode* root, vector<int> &path, vector<vector<int>> &paths){
    	path.push_back(root->val);
    	if(root->left != NULL){
    		search(root->left, path, paths);
    		path.pop_back();
    	}
    	if(root->right != NULL){
    		search(root->right, path, paths);
    		path.pop_back();
    	}
    	if(root->left == NULL && root->right == NULL){
    		paths.push_back(path);
    	}
    }
    
};
