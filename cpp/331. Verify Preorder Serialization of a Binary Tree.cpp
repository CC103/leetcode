class Solution {
public:
    bool isValidSerialization(string preorder) {
        stringstream ss(preorder);
        string token;
        vector<string> v;
        int degree = 1;
        while(getline(ss, token, ',')){
        	degree--;
        	if(degree < 0)
        		return false;
        	if(token != "#")
        		degree += 2;
        }
        return (degree == 0);
    }
};
