class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> ret;
        for(int i = 1; i <= n; i++){
            int a = i % 3;
            int b = i % 5;
            if(a != 0 && b != 0){
                ret.push_back(to_string(i));
            }
            else if(a == 0 && b == 0){
                ret.push_back("FizzBuzz");
            }
            else if(a == 0){
                ret.push_back("Fizz");
            }
            else{
                ret.push_back("Buzz");
            }
        }
        return ret;
    }
};
