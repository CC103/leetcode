#include<iostream>
#include<vector>
using namespace std;
#define INT_MAX 2147483647

class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        cur = -1;
        min.push_back(INT_MAX);
    }
    
    void push(int x) {
        vec.push_back(x);
        cur++;
        if(x <= min[min.size() - 1])
            min.push_back(x);
    }
    
    void pop() {
        if(vec[cur] == min[min.size() - 1])
            min.erase(min.end() - 1);
        vec.erase(vec.begin() + cur);
        cur--;
        
    }
    
    int top() {
        return vec[cur];
    }
    
    int getMin() {
        return min[min.size() - 1];
    }
private:
    vector<int> vec;
    vector<int> min;
    int cur;
    
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
