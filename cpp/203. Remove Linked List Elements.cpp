#include<iostream>

 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode* removeElements(ListNode* head, int val) {
		if (head == NULL)
			return head;
		ListNode* cur = head;
		ListNode* next = cur->next;
		while (next != NULL){
			if (next->val == val){
				if (next->next != NULL){
					cur->next = next->next;
					next = cur->next;
					continue;
				}
				else{
					cur->next = NULL;
					break;
				}
			}
			cur = cur->next;
			next = cur->next;
		}
		if (head->val == val)
			return head->next;
		else
			return head;
	}
};
