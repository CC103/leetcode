#include <iostream>
class Solution {
public:
    bool isPerfectSquare(int num) {
    	if(num < 1)
    		return false;
        int stepLength = 100;
        int cur = 1;
        int end = 0;
        int start = 0;
        while(1){
        	//This situation means no answer so 'cur' keeps decreasing until 'start' 
        	if(cur == start)
        		return false;
        	int sqr = cur * cur;
        	if(sqr == num)
        		return true;
        	else if(sqr < num){
        		start = cur;
        		if(end){
        			cur = (end + start) / 2;
        		}
        		else{
        			cur += stepLength;
        			//To accelerate the search, I make 'stepLength' double everytime
        			stepLength *= 2;
        		}
        	}
        	else{
        		end = cur;
        		cur = (end + start) / 2;
        	}
        }
        
    }
};
