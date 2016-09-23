class Solution {
public:
    bool isAdditiveNumber(string num) {
        for(int i = 1; i <= num.size() / 2; i++){
            for(int j = 1; j <= (num.size() - i) / 2; j++){
                if(check(num.substr(0, i), num.substr(i, j), num.substr(i + j))) return true;
            }
        }
        return false;
    }
    bool check(string first, string second, string third){
        if((first.size() > 1 && first[0] == '0') || (second.size() > 1 && second[0] == '0')){
            return false;
        }
        else{
            string sum = strAdd(first, second);
            cout << first << " " << second << " " << sum << endl;
            if(sum == third){
                return true;
            }
            else if(sum.size() >= third.size() || sum.compare(third.substr(0, sum.size())) != 0){
                return false;
            }
            else{
                return check(second, sum, third.substr(sum.size()));
            }
        }
    }

    string strAdd(string first, string second){
        int fir = first.size() - 1, sec = second.size() - 1, carry = 0, sum = 0;
        string ret;
        while(fir >= 0 || sec >= 0){
            sum = carry + (fir >= 0 ? first[fir--] - '0' : 0) + (sec >= 0 ? second[sec--] - '0' : 0);
            ret.push_back(sum % 10 + '0');
            carry = sum / 10;
        }
        if(carry){
            ret.push_back('1');
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};
