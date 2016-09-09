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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1 == NULL)
            return l2;
        if(l2 == NULL)
            return l1;
        ListNode* head = l1;
        int sum = 0, carry = 0;
        //cout << 1;
        while(l1->next != NULL && l2->next != NULL){
            sum = l1->val + l2->val + carry;
            l1->val = sum % 10;
            carry = sum / 10;
            l1 = l1->next;
            l2 = l2->next;
        }
        //cout << 2;
        // calculate the last common digit
        sum = l1->val + l2->val + carry;
        l1->val = sum % 10;
        carry = sum / 10;
        // the length of two lists are same
        // cout << l1->next << " " << l2->next;
        if(l1->next == NULL && l2->next == NULL){
            cout << 1 << " " << carry;
            if(carry){
                cout << 2;
                ListNode newNode(1);
                cout << 3;
                l1->next = &newNode;
                cout << 4;
            }
            cout << 5;
            return head;
        }
        // l1 is shorter than l2
        if(l1->next == NULL){
            l1->next = l2->next;
            l1 = l1->next;
            while(carry && l1->next != NULL){
                sum = l1->val + carry;
                l1->val = sum % 10;
                carry = sum / 10;
                l1 = l1->next;
            }
            if(carry && l1->next == NULL){
                sum = l1->val + carry;
                l1->val = sum % 10;
                carry = sum / 10;
                if(carry){
                    ListNode newNode(1);
                    l1->next = &newNode;
                }
            }
            return head;
        }
        // l2 is shorter than l1
        if(l2->next == NULL){
            l1 = l1->next;
            while(carry && l1->next != NULL){
                sum = l1->val + carry;
                l1->val = sum % 10;
                carry = sum / 10;
                l1 = l1->next;
            }
            if(carry && l1->next == NULL){
                sum = l1->val + carry;
                l1->val = sum % 10;
                carry = sum / 10;
                if(carry){
                    ListNode newNode(1);
                    l1->next = &newNode;
                }
            }
        }
        return head;
    }
};
