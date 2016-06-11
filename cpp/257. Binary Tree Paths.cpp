#include<iostream>
#include<string>
#include<vector>
#include<sstream>
using namespace std;
 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	void searchTree(TreeNode* root, vector<string>& paths, string& path){
		path += "->";
		stringstream ss;
		string temp;
		ss << root->val;
		ss >> temp;
		ss.clear();
		ss.str("");
		path += temp;
		if (root->left == NULL && root->right == NULL){
			//path.erase(path.begin(), path.begin() + 2);
			paths.push_back(path);
			return;
		}
		if (root->left != NULL){
			searchTree(root->left, paths, path);
			for (int i = path.size() - 1; i >= 0; i--){
				if (path[i] == '>'){
					path.erase(path.begin() + i - 1, path.end());
					break;
				}
				path.erase(path.begin() + i);
			}
		}
		if (root->right != NULL){
			searchTree(root->right, paths, path);
			for (int i = path.size() - 1; i >= 0; i--){
				if (path[i] == '>'){
					path.erase(path.begin() + i - 1, path.end());
					break;
				}
			}
		}
	}
	vector<string> binaryTreePaths(TreeNode* root) {
		string path;
		vector<string> paths;
		if (root == NULL)
			return paths;
		searchTree(root, paths, path);
		for (int i = 0; i < paths.size(); i++){
			paths[i].erase(paths[i].begin(), paths[i].begin() + 2);
		}
		return paths;

	}
};
