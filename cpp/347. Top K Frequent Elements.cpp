/*
速度有点慢，以后要优化
*/
#include<iostream>
#include<vector>
#include<queue>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	struct element{
		int value;
		int frequency;
		bool operator < (const element arg) const{
			return frequency < arg.frequency;
		}
	};

	priority_queue<element> s;

	vector<int> topKFrequent(vector<int>& nums, int k) {
		sort(nums.begin(), nums.end());
		int fre = 0;
		for (int i = 0; i < nums.size() - 1; i++){
			fre++;
			if (i == nums.size() - 1){
				element e;
				e.value = nums[i];
				e.frequency = fre;
				s.push(e);
				break;
			}
			if (nums[i + 1] != nums[i]){
				element e;
				e.value = nums[i];
				e.frequency = fre;
				fre = 0;
				s.push(e);
			}
		}
		vector<int> ret;
		while (k){
			ret.push_back(s.top().value);
			s.pop();
			k--;
		}
		return ret;
	}
};

int main(){
	vector<int> m = { 1, 2, 2, 2, 3, 3, 3, 5, 5, 6, 6, 6, 6, 6, 9, 8, 7, 7, 7, 8 };
	Solution s;
	vector<int> ret;
	ret = s.topKFrequent(m, 2);
	cout << ret[0] << endl << ret[1];
	system("pause");
	return 0;
}
