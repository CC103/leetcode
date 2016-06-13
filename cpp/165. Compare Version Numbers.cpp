#include<iostream>
#include<string>
#include<vector>
#include<sstream>
using namespace std;
class Solution {
public:
    void split(string version, char delim, vector<int>& elems) {
        stringstream ss(version);
        string item;
        while(getline(ss, item, '.')){
            elems.push_back(atoi(item.c_str()));
        }
    }
    int compareVersion(string version1, string version2) {
        vector<int> elems1;
        vector<int> elems2;
        split(version1, '.', elems1);
        split(version2, '.', elems2);
        while(elems1.back() == 0){
            elems1.pop_back();
        }
        while(elems2.back() == 0){
            elems2.pop_back();
        }
        int size = elems1.size() > elems2.size() ? elems2.size() : elems1.size();
        for(int i = 0; i < size; i++){
            if(elems1[i] > elems2[i])
                return 1;
            if(elems2[i] > elems1[i])
                return -1;
        }
        if(elems1.size() > elems2.size())
            return 1;
        if(elems2.size() > elems1.size())
            return -1;
        return 0;
    }
};
