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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL)
            return head;
        ListNode dummy(0);
        dummy.next = head;
        ListNode *last = &dummy;
        while(head){
            if(head->next == NULL)
                break;
            if(head->next->val != head->val){
                last = last->next;
                head = head->next;
            }
            else{
                int temp = head->val;
                while(head != NULL && head->val == temp){
                    head = head->next;
                }
                last->next = head;
            }
        }
        return dummy.next;

    }
};
