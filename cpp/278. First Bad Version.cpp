#include<iostream>
#include<stdlib.h>
using namespace std;
// Forward declaration of isBadVersion API.
bool isBadVersion(int version);
class Solution {
public:
	int firstBadVersion(int n) {
		int lowerBound = 1;
		int upperBound = n;
		int bound = n - 1;
		while (lowerBound <= upperBound){
			int middle = bound / 2 + lowerBound;
			if (isBadVersion(middle) && !isBadVersion(middle - 1)){
				return middle;
			}
			if (isBadVersion(middle)){
				upperBound = middle - 1;
			}
			else{
				lowerBound = middle + 1;
			}
			bound = upperBound - lowerBound;
		}
		return -1;
	}
};
