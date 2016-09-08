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
    void reorderList(ListNode* head) {
        if(head == NULL)
            return;
        ListNode *fast = head;
        ListNode *slow = head;
        while(fast->next != NULL){
            fast = fast->next;
            slow = slow->next;
            if(fast->next != NULL)
                fast = fast->next;
        }
        //the nodes after "slow" should be inserted
        if(slow->next == NULL)
            return;
        ListNode *right = slow->next;
        slow->next = NULL;
        //reverse the right list
        ListNode *temp1;
        ListNode *temp2 = NULL;
        while(right->next != NULL){
            temp1 = right->next;
            right->next = temp2;
            temp2 = right;
            right = temp1;
        }
        right->next = temp2;
        ListNode *test = right;
        //insert until the right list is empty
        ListNode *left = head;
        ListNode *ltemp;
        ListNode *rtemp;
        while(right != NULL){
            ltemp = left->next;
            left->next = right;
            rtemp = right->next; 
            right->next = ltemp;
            left = ltemp;
            right = rtemp;
        }
    }
};
