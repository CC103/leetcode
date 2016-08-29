class Solution {
public:
    int calculate(string s) {
        stack<int> stack;
        int num = 0;
        char lastOper = '+';
        s += "+";
        for(auto c : s){
            if(c == ' ')
                continue;
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }
            else{
                if(lastOper == '+')
                    stack.push(num);
                else if(lastOper == '-')
                    stack.push(-1 * num);
                else if(lastOper == '*'){
                    int n = stack.top();
                    stack.pop();
                    stack.push(n * num);
                }
                else if(lastOper == '/'){
                    int n = stack.top();
                    stack.pop();
                    stack.push(n / num);
                }
                lastOper = c;    
                num = 0;
            }
            
        }
        int ret = 0;
        while(!stack.empty()){
            ret += stack.top();
            stack.pop();
        }
        return ret;
    }
};
