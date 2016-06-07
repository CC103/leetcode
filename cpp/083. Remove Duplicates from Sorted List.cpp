#include<iostream>
#include<stdlib.h>

 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	ListNode* deleteDuplicates(ListNode* head) {
		ListNode* p = head;
		while (p->next != NULL){
			if (p->val == p->next->val)
				p->next = p->next->next;
			else
				p = p->next;
		}
		return head;
	}
};

int main(){
	ListNode n1(1);
	ListNode n2(1);
	ListNode n3(2);
	ListNode n4(2);
	ListNode n5(3);
	n1.next = &n2;
	n2.next = &n3;
	n3.next = &n4;
	n4.next = &n5;
	Solution s;
	s.deleteDuplicates(&n1);
	std::cout << n1.val << n1.next->val << n1.next->next->val;
	system("pause");
	return 0;
}
