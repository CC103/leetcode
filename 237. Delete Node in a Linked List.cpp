#include <iostream>
#include <stdlib.h>
using namespace std;
struct ListNode{
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL){}
};

class Solution {
public:
	void deleteNode(ListNode* node) {
		if ((node->next)->next == NULL) {
			node->val = (node->next)->val;
			//delete(node->next); 程序在这里报错，对delete函数的机制不了解
			node->next = NULL;
		}
		else{
			node->val = (node->next)->val;
			deleteNode(node->next);
		}
	}
};

int main(){
	ListNode a(1);
	ListNode b(2);
	ListNode c(3);
	ListNode d(4);
	ListNode e(5);
	a.next = &b;
	b.next = &c;
	c.next = &d;
	d.next = &e;
	Solution s;
	s.deleteNode(&a);
	system("pause");
	return 0;
}
