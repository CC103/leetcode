/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if(head == NULL)
            return head;
        if(m == n)
            return head;
        ListNode dummy(0);
        dummy.next = head;
        ListNode *pre = &dummy;
        for(int i = 0; i < m - 1; i++) 
            pre = pre->next;
        ListNode* cur = pre->next;
        ListNode* last = pre;
        int step = n - m + 1;
        ListNode *temp;
        ListNode *subHead;
        for(int i = 0; i < step; i++){
            if(i == 0){
                subHead = cur;
                cur = cur->next;
                last = last->next;
                continue;
            }
            temp = cur->next;
            cur->next = last;
            last = cur;
            cur = temp;
        }
        pre->next = last;
        subHead->next = cur;
        return dummy.next;
    }
};
