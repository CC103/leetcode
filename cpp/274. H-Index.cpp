class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int size = citations.size();
        int max = 0;
        for(int i = 0; i < citations.size(); i++){
        	int index = min(size - i, citations[i]);
        	if(index > max)
        		max = index;
        }
        return max;
    }
};
