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
    ListNode *detectCycle(ListNode *head) {
    	if(head == NULL || head->next == NULL)
    		return NULL;
    	ListNode* fir = head;
    	ListNode* sec = head;
    	bool isCircle = false;
    	while(sec != NULL){
    		fir = fir->next;
    		if(sec->next != NULL)
    			sec = sec->next->next;
    		else
    			return NULL;
    		if(fir == sec){
    			isCircle = true;
    			break;
    		}
    	}
    	if(!isCircle)
    		return NULL;
    	fir = head;
    	//the distance from head to cycle begin equals to that from meeting node to begin
    	while(fir != sec){
    		fir = fir->next;
    		sec = sec->next;
    	}
    	return fir;
    }
};
