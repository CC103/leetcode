class Solution {
public:
    int calculate(string s) {
        stringstream ss;
        vector<char> oper;
        vector<int> num;
        int size = s.size();
        for(int i = 0; i < size;){
            if(s[i] == ' ')
                s.erase(s.begin() + i);
            else
                i++;
        }
        int last = 0;
        for(int i = 0; i < size; i++){
            if(s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/'){
                oper.push_back(s[i]);
                int temp;
                ss << s.substr(last, i - last);
                ss >> temp;
                num.push_back(temp);
                ss.clear();
                ss.str("");
                last = i + 1;
            }     
        }
        int temp;
        ss << s.substr(last);
        ss >> temp;
        num.push_back(temp);
        for(auto o : oper){
            cout << o << " ";
        }
        cout << endl;
        for(auto i : num){
            cout << i <<" ";
        }
        for(int i = 0; i < oper.size();){
            if(oper[i] == '*'){
                oper.erase(oper.begin() + i);
                num[i] = num[i] * num[i + 1];
                num.erase(num.begin() + i + 1);
            }
            else if(oper[i] == '/'){
                oper.erase(oper.begin() + i);
                num[i] = num[i] / num[i + 1];
                num.erase(num.begin() + i + 1);
            }
            else
                i++;
        }
        for(int i = 0; i < oper.size();){
            if(oper[i] == '+'){
                oper.erase(oper.begin() + i);
                num[i] = num[i] + num[i + 1];
                num.erase(num.begin() + i + 1);
            }
            else if(oper[i] == '-'){
                oper.erase(oper.begin() + i);
                num[i] = num[i] - num[i + 1];
                num.erase(num.begin() + i + 1);
            }
            else
                i++;
        }
        return num[0];
    }
};
