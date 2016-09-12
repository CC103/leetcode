class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> ret;
        string ip;
        dfs(s, ret, ip, 0, 0);
        return ret;
    }
    void dfs(string &s, vector<string> &ret, string ip, int start, int step){
        //cout << ip << " ";
        if(start == s.size() && step == 4){
            ip.erase(ip.end() - 1);
            ret.push_back(ip);
            return;
        }
        if(s.size() - start > 3 * (4 - step) || s.size() - start < (4 - step))
            return;
        int num = 0;
        for(int i = start; i < start + 3 && i < s.size(); i++){
            num = num * 10 + s[i] - '0';
            if(num <= 255){
                ip += s[i];
                dfs(s, ret, ip + '.', i + 1, step + 1);
            }
            if(num == 0)
                break;
        }
    }
};
