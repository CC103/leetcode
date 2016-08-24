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
        map<int, int> hash;
        map<int, int>::iterator it;
        ListNode dummy(0);
        dummy.next = head;
        while(head){
            it = hash.find(head->val);
            if(it != hash.end())
                it->second++;
            else
                hash[head->val] = 0;
            head = head->next;
        }
        head = dummy.next;
        ListNode *last = &dummy;
        while(head){
            if(hash.find(head->val)->second){
                last->next = head->next;
                head = head->next;
            }
            else{
                last = head;
                head = head->next;
            }
        }
        return dummy.next;

    }
};
