#include<iostream>
#include<stdlib.h>
using namespace std;
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };

class Solution {
public:
	ListNode* removeNthFromEnd(ListNode* head, int n) {
		ListNode* p0 = head;
		ListNode* p1 = head;
		ListNode* p2 = new ListNode(0);
		p2->next = head;
		for (int i = 0; i < n - 1; i++){
			p1 = p1->next;
		}
		if (p1->next == NULL){
			head = head->next;
			return head;
		}
		while (p1->next != NULL){
			p2 = p0;
			p0 = p0->next;
			p1 = p1->next;
		}
		p2->next = p0->next;
		p0->next = NULL;
		return head;

	}
};
int main(){
	ListNode n1(1);
	ListNode n2(2);
	ListNode n3(3);
	n1.next = &n2;
	n2.next = &n3;
	Solution s;
	ListNode* p = s.removeNthFromEnd(&n1, 3);
	
	while (p != NULL){
		cout << p->val << endl;
		p = p->next;
	}
	system("pause");
	return 0;
}
