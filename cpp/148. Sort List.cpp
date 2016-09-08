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
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head->next == NULL)
            return head;
        ListNode *fast = head->next->next;
        ListNode *slow = head;
        while(fast != NULL && fast->next != NULL){
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode *h2 = sortList(slow->next);
        slow->next = NULL;
        // ListNode *test;
        // test = h2;
        // while(test!=NULL){
        //     cout << test->val << " ";
        //     test = test->next;
        // }
        return merge(sortList(head), h2);
    }

    ListNode* merge(ListNode *h1, ListNode *h2){
        ListNode virtualHead = ListNode(0);
        ListNode *cur = &virtualHead;
        while(h1 != NULL && h2 != NULL){
            if(h1->val < h2->val){
                cur->next = h1;
                h1 = h1->next;
            }
            else{
                cur->next = h2;
                h2 = h2->next;
            }
            cur = cur->next;
        }
        if(h1 == NULL)
            cur->next = h2;
        else
            cur->next = h1;
        return virtualHead.next;
    }
};
