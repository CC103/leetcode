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
	ListNode* reverseList(ListNode* head) {
		int arr[100000] = { 0 };
		int i = 0;
		ListNode* p = head;
		while (p != NULL){
			arr[i] = p->val;
			i++;
			p = p->next;
		}
		std::cout << i;
		//特别要注意，此时的i是大于最后一个有值的下标的，因为i最后一次循环中+1，所以如果不处理，在下面的循环中就会多循环一次，导致给一个NULL的val赋值了
		p = head;
		for (i = i - 1; i >= 0; i--){
			p->val = arr[i];
			p = p->next;
		}
		
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
	ListNode *head = s.reverseList(&n1);
	system("pause");
	return 0;
}
