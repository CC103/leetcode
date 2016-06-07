#include<iostream>
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode* swapPairs(ListNode* head) {
		if (head == NULL || head->next == NULL)
			return head;
		ListNode *newListHead = head->next;
		ListNode *tmp = new ListNode(0);
		tmp->next = head;
		while (head != NULL && head->next != NULL){
			ListNode *p = head->next;
			head->next = p->next;
			p->next = head;
			tmp->next = p;
			tmp = tmp->next->next;
			head = head->next;
		}
		return newListHead;
	}
};
