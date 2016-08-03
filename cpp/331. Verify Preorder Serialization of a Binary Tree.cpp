class Solution {
public:
    bool isValidSerialization(string preorder) {
    	if(preorder.empty())
    		return false;

        stringstream ss(preorder);
        string token;
        vector<string> v;
        while(getline(ss, token, ','))
        	v.push_back(token);

        if(v.size() == 1){
        	//empty tree
        	return(v[0] == "#");
        }
        if(v.size() == 2)
        	return false;
        int flag;
        while(v.size() != 1){
        	flag = 0;
        	for(int i = 1; i < v.size() - 1;){
        		if(v[i] == "#" && v[i + 1] == "#" && v[i - 1] != "#"){
        			//show that this is not a dead loop
        			flag = 1;
        			//erase i
        			v.erase(v.begin() + i);
        			//erase i+1
        			//erase has changed the size
        			v.erase(v.begin() + i);
        			v[i - 1] = "#";
        		}
        		i++;

        	}
        	if(flag == 0)
        		return false;
        }
        if(v[0] == "#")
        	return true;
        return false;
    }
};
