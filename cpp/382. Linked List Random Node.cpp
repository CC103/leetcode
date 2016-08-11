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
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    Solution(ListNode* head) {
        head_ = head;
        while(head != NULL){
            length_++;
            head = head->next;
        }
        srand((int)time(0));
    }
    
    /** Returns a random node's value. */
    int getRandom() {  
        int pos = rand() % length_;
        cout << pos << " ";
        ListNode *p = head_;
        while(pos){
            p = p->next;
            pos--;
        }
        return p->val; 
        
    }
private:
    int length_ = 0;
    ListNode* head_;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
