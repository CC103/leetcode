#include<iostream>

struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		if (l1 == NULL && l2 == NULL)
			return NULL;
		if (l1 == NULL)
			return l2;
		if (l2 == NULL)
			return l1;
		ListNode *head, *body, *newListHead;
		if (l1->val <= l2->val){
			head = l2;
			body = l1;
		}
		else{
			head = l1;
			body = l2;
		}
		newListHead = body;
		while (head != NULL){
			if (body->next == NULL){
				body->next = head;
				break;
			}
			ListNode *p;
			if (head->val <= body->next->val){
				p = head;
				head = head->next;
				p->next = body->next;
				body->next = p;
				body = body->next;
			}
			else
				body = body->next;
		}
		return newListHead;
	}
};
