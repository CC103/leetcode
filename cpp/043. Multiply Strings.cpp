class Solution {
public:
    string multiply(string num1, string num2) {
        string sum(num1.size() + num2.size(), '0');
        for(int i = num1.size() - 1; i >= 0; i--){
            int carry = 0;
            for(int j = num2.size() - 1; j >= 0; j--){
                int temp = sum[i + j + 1] - '0' + (num1[i] - '0') * (num2[j] - '0') + carry;
                sum[i + j + 1] = temp % 10 + '0'; 
                carry = temp / 10;
            }
            sum[i] += carry;
        }
        //cout << sum;
        int i = 0;
        while(sum[i] == '0' && i < sum.size()){
            i++;
        }
        if(i == sum.size())
            return "0";
        else
            return sum.substr(i);
    }
};
