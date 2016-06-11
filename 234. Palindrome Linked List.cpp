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
	
	ListNode* findMiddle(ListNode* head){
		ListNode* p1 = head;
		ListNode* p2 = head;
		//如果p2==NULL，p2->next就不会判断，因此不会报错
		while (p2 && p2->next){
			p1 = p1->next;
			p2 = p2->next->next;
		}
		return p1;
	}
	ListNode* reverseList(ListNode* head){
		ListNode* p = NULL;
		while (head){
			ListNode* q = head->next;
			head->next = p;
			//p存储head的上一个节点，初始为NULL
			p = head;
			head = q;
		}
		return p;
	}
	bool isPalindrome(ListNode* head) {
		ListNode* pMid = findMiddle(head);
		ListNode* pRev = reverseList(pMid);
		for (; head != pMid; head = head->next, pRev = pRev->next){
			if (head->val != pRev->val)
				return false;
		}
		return true;
	}
};

int main(){
	ListNode n1 = (1);
	ListNode n2 = (2);
	ListNode n3 = (1);
	ListNode n4 = (1);
	n1.next = &n2;
	n2.next = &n3;
	n3.next = &n4;
	Solution s;
	cout << s.isPalindrome(&n1);
	system("pause");
	return 0;
}
