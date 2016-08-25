class Solution {
public:
    vector<int> lexicalOrder(int n) {
        stack<int> s;
        vector<int> ret;
        for(int i = 1; i < 10; i++){
            s.push(i);
            generate(ret, s, n);
            s.pop();
        }
        return ret;
    }

    void generate(vector<int> &ret, stack<int> &s, int n){
        int num = turnStacktoInt(s);
        if(num > n)
            return;
        ret.push_back(num);
        for(int i = 0; i < 10; i++){
            s.push(i);
            generate(ret, s, n);
            s.pop();
        }
        return;
    }

    int turnStacktoInt(stack<int> s){
        int i = 0;
        int r = 1;
        while(!s.empty()){
            i += r * s.top();
            s.pop();
            r *= 10;
        }
        return i;
    }
};
