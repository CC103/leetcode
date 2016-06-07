#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<int> getRow(int rowIndex) {
        //开始理解行号从1开始；后来发现题意从0开始，因此++
        rowIndex++;
        vector<int> v;
        v.push_back(1);
        if(rowIndex == 1)
            return v;
        v.push_back(1);
        if(rowIndex == 2)
            return v;
        int row = 3;
        while(row <= rowIndex){
        for(int i = 1; i < row - 1; i++){
            int tmp = v[i - 1] + v[i];
            v[i - 1] = tmp;
        }
        v.insert(v.begin(), 1);
        row++;
        }
        return v;
    }
};
