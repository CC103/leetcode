class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        if(tokens.empty()) return 0;
        stack<int> stack;
        stringstream ss;
        for(auto i : tokens){
            if(i == "+" || i == "-" || i == "*" || i == "/"){
                int first, second;
                second = stack.top();
                stack.pop();
                first = stack.top();
                stack.pop();
                int result;
                if(i == "+") result = first + second;
                else if(i == "-") result = first - second;
                else if(i == "*") result = first * second;
                else if(i == "/") result = first / second;
                stack.push(result);
            }
            else{
                int num;
                ss << i;
                ss >> num;
                ss.clear();
                ss.str("");
                stack.push(num);
            }
        }
        return stack.top();
    }
};
