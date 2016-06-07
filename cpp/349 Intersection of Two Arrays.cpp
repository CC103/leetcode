#include <iostream>
#include <vector>
#include <set>
#include <stdlib.h>
using namespace std;

int main(){
	vector<int> nums1 = { 1, 2, 3, 4, 5, 6, 9, 9 };
	vector<int> nums2 = { 2, 4, 6, 8, 9 };
	set<int> temp;
	vector<int> result;
	for (int i = 0; i < nums1.size(); i++) {
		for (int j = 0; j < nums2.size(); j++){
			if (nums1[i] == nums2[j])
				temp.insert(nums1[i]);
		}
	}
	set<int>::iterator it;
	for (it = temp.begin(); it != temp.end(); it++){
		result.push_back(*it);
	}
	for (int i = 0; i < result.size(); i++)
		cout << result[i] << endl;
	system("pause");
	return 0;
}
