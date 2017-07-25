import java.util.Stack;

public class MinStack {
    Stack<Long> stack;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        }
        else {
            stack.push(x - min);
            if (x < min) min = x;
        }

    }

    public void pop() {
        if (stack.isEmpty()) return;
        long p = stack.pop();
        if (p < 0) min -= p;
    }

    public int top() {
        long p = stack.peek();
        if (p < 0) return (int) min;
        else return (int) (p + min);
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
