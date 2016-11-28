class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        if(digits.empty()){
        	digits.insert(digits.begin(), 1);
        	return digits;
        }
        int carry = 1, sum;
        for(int i = digits.size() - 1; i >= 0; i--){
        	sum = digits[i] + carry;
        	digits[i] = sum % 10;
        	carry = sum / 10;
        }
        if(carry) digits.insert(digits.begin(), 1);
        return digits;
    }
};