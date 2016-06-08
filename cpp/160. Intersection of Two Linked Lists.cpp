#include<iostream>
#include<stdlib.h>
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
		ListNode* res = NULL;
		ListNode* p = headA;
		while (p != NULL){
				p->val *= -1;
				p = p->next;
		}
		ListNode* q = headB;
		while (q != NULL){
			if (q->val < 0){
				res = q;
				break;
			}
			q = q->next;
		}
		p = headA;
		while (p != NULL){
			p->val *= -1;
			p = p->next;
		}
		return res;

	}
};

int main(){
	ListNode* p = NULL;
	ListNode* q = NULL;
	ListNode* res;
	Solution s;
	res = s.getIntersectionNode(p, q);
	system("pause");
	return 0;
}
