/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        vector<int> v;
        ListNode* h = head;
        while(h != NULL){
        	v.push_back(h->val);
        	h = h->next;
        }
        for(int i = 1; i < v.size(); i++){
        	int key = v[i];
        	int j = i - 1;
        	while(j >= 0 && v[j] > key){
        		v[j + 1] = v[j];
        		j--;
        	}
        	v[j + 1] = key;
        }
        h = head;
        int i = 0;
        while(h != NULL){
        	h->val = v[i];
        	h = h->next;
        	i++;
        }
        return head;
    }
};
