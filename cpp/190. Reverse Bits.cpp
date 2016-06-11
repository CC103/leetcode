#include<iostream>
#include<stdlib.h>
typedef unsigned __int32 uint32_t;
using namespace std;
class Solution {
public:
	uint32_t reverseBits(uint32_t n) {
		uint32_t ret = 0;
		for (int i = 0; i < 32; i++){
			ret = ret * 2 + (n & 0x1);
			n /= 2;
		}
		return ret;
	}
};
int main(){
	Solution s;
	cout << s.reverseBits(43261596);
	system("pause");
	return 0;
}
