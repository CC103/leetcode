#include<iostream>
#include<vector>
#include<stdlib.h>
using namespace std;
class Solution {
public:
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
		int p = 0;
		for (int i = 0, j = 0; i < n;){
			cout << "p" << p << endl;
			if (p >= m){
				nums1[j] = nums2[i];
				j++;
				i++;
				continue;
			}
			if (nums2[i] < nums1[j]){
				nums1.insert(nums1.begin() + j, nums2[i]);
				nums1.erase(nums1.end() - 1);
				i++;
				j++;
				continue;
			}
			j++;
			p++;
		}
	}
};

int main(){
	vector<int> v1 = { 1, 2, 3, 4, 5, 7, 0, 0, 0, 0};
	vector<int> v2 = { 1, 6, 8 };
	Solution s;
	s.merge(v1, 6, v2, 3);
	for (int i = 0; i < v1.size(); i++){
		cout << v1[i] << endl;
	}
	system("pause");
	return 0;
}
