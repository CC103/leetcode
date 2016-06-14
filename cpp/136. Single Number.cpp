#include<iostream>
#include<string>
#include<vector>
using namespace std;
//数据取值范围是（-20000, 20000）
class Solution {
public:
	int singleNumber(vector<int>& nums) {
		int hash[40000] = { 0 };
		for (int i = 0; i < nums.size(); i++){
			if (nums[i] < 0)
				hash[nums[i] * -1 + 20000]++;
			else
				hash[nums[i]]++;
		}
		for (int i = 0; i < 40000; i++){
			if (hash[i] == 1){
				if (i < 20000)
					return i;
				else
					return (i - 20000) * -1;
			}

		}
		return 0;
	}
};
/*
//使用异或的方法，发现通过测例的速度没有提升，说明位运算是很耗时的
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int result = 0;
        for(int n:nums){
            result ^= n;
        }
        return result;

    }
};
*/
