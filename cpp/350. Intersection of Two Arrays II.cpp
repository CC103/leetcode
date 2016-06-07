#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
	vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
		int hashTable[10000] = { 0 };
		for (int i = 0; i < nums1.size(); i++){
			hashTable[nums1[i]]++;
		}
		vector<int> res;
		for (int i = 0; i < nums2.size(); i++){
			if (hashTable[nums2[i]] > 0)
				res.push_back(nums2[i]);
			hashTable[nums2[i]]--;
		}
		return res;
	}
};
