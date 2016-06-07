#include<iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	bool hasCycle(ListNode *head) {
		if (head == NULL)
			return false;
		ListNode* p = head;
		p->val = 299267;
		while (p->next != NULL){
			if (p->next->val == 299267)
				return true;
			p = p->next;
			p->val = 299267;
		}
		return false;
	}
};
