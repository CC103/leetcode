class Solution {
public:
    void reverseWords(string &s) {
        if(s.empty()) return;
        stack<string> strStack;
        string world;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == ' ' && !world.empty()){
                strStack.push(world);
                world.clear();
            }
            else if(s[i] != ' '){
                world.push_back(s[i]);
            }
        }
        if(!world.empty()){
            strStack.push(world);
        }
        s.clear();
        while(!strStack.empty()){
            s += strStack.top();
            strStack.pop();
            s.push_back(' ');
        }
        // erase the last space
        if(!s.empty()){
            s.erase(s.end() - 1);
        }
    }
};
