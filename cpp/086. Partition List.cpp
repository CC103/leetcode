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
    ListNode* partition(ListNode* head, int x) {
    	if(head == NULL)
    		return head;
    	ListNode* tail = head;
    	while(tail->next != NULL){
    		tail = tail->next;
    	}
    	ListNode* end = tail;
    	ListNode* cur = head;
    	ListNode* last = new ListNode(0);
    	last->next = head;
    	ListNode* trueHead = last;  
    	while(cur != end){
    		if(cur->val >= x){
    			last->next = cur->next;
    			tail->next = new ListNode(cur->val);
    			tail = tail->next;
    			cur = cur->next;
    		}
    		else{
    			cur = cur->next;
    			last = last->next;
    		}
    	}

    	if(cur->val >= x){
    		tail->next = new ListNode(cur->val);
    		tail = tail->next;
    		last->next = cur->next;
    	}
        return trueHead->next;
    }
};
