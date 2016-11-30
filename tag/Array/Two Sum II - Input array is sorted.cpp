class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> ret(2);
        if(numbers.empty()) return ret;
        for(int head = 0, nail = numbers.size() - 1;;head++){
        	int start = head + 1, mid, num = target - numbers[head];
        	while(start <= nail){
        		mid = (start + nail) / 2;
        		if(numbers[mid] == num){
        			// output indice starts from 1
        			ret.push_back(head + 1);
        			ret.push_back(mid + 1);
        			return ret;
        		}
        		else if(numbers[mid] < num) start = mid + 1;
        		else nail = mid - 1;
        	}
        }
    }
};