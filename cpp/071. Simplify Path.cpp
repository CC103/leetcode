class Solution {
public:
    string simplifyPath(string path) {
        stack<string> strStack;
        string str;
        for(int i = 0; i < path.size(); i++){
            if(path[i] == '/'){
                if(!str.empty() && str != "."){
                    strStack.push(str);
                }
                str.clear();
            }
            else{
                str.push_back(path[i]);
            }
        }
        // the path may not end with '/'
        if(!str.empty() && str != ".")
            strStack.push(str);
        stack<string> simplifyStrStack;
        int numOfReturn = 0;
        while(!strStack.empty()){
            string temp = strStack.top();
            if(temp == ".."){
                numOfReturn += 1;
                strStack.pop();
            }
            else{
                if(numOfReturn){
                    numOfReturn -= 1;
                    strStack.pop();
                }
                else{
                    simplifyStrStack.push(temp);
                    strStack.pop();
                }
            }
        }
        string ret;
        while(!simplifyStrStack.empty()){
            ret = ret + "/" + simplifyStrStack.top();
            simplifyStrStack.pop();
        }
        if(ret.empty()) return "/";
        return ret;
    }
};
