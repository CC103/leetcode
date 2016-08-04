/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode* sortedListToBST(ListNode* head) {
    	if(head == NULL)
    		return NULL;
        vector<int> list;
        while(head != NULL){
        	list.push_back(head->val);
        	head = head->next;
        }
        return convert(list, 0, list.size() - 1);

    }
    TreeNode* convert(vector<int>& list, int start, int end){
    	if(start > end)
    		return NULL;
    	//to make sure mid is the middle(odd) or right next to true middle(even)
    	int mid = (start + end + 1) / 2;
    	TreeNode* p = new TreeNode(list[mid]);
    	p->left = convert(list, start, mid - 1);
    	p->right = convert(list, mid + 1, end);
    	return p;
    }
};
