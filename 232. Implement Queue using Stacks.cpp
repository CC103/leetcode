#include<iostream>
#include<stdlib.h>
#include<stack>
using namespace std;

class Queue {
public:
	// Push element x to the back of queue.
	void push(int x) {
		while (!p.empty()){
			s.push(p.top());
			p.pop();
		}
		s.push(x);
		while (!s.empty()){
			p.push(s.top());
			s.pop();
		}
	}

	// Removes the element from in front of queue.
	void pop(void) {
		p.pop();
	}

	// Get the front element.
	int peek(void) {
		return p.top();
	}

	// Return whether the queue is empty.
	bool empty(void) {
		return p.empty();
	}
private:
	stack<int> s;
	stack<int> p;
};
int main(){
	Queue s;
	s.push(1);
	s.push(2);
	s.push(3);
	s.pop();
	cout <<  s.empty();
	system("pause");
	return 0;
}
