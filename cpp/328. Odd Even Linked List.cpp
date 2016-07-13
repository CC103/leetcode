/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 #include <iostream>
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head == NULL || head->next ==NULL)
            return head;
        ListNode* oddTail = head;
        ListNode* cur = head->next;
        ListNode* last = head;
        //num is the number of cur
        int num = 2;
        while(cur != NULL){
            if(num % 2 == 1){
                last->next = cur->next;
                cur->next = oddTail->next;
                oddTail->next = cur;
                oddTail = cur;
                cur = last->next;
                num++;
            }
            else{
                cur = cur->next;
                last = last->next;
                num++;
            }
            
        }
        return head;
        
    }
};
