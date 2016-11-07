/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<int> findRightInterval(vector<Interval>& intervals) {
        map<int, int> hash;
        for(int i = 0; i < intervals.size(); i++){
            hash[intervals[i].start] = i; 
        }
        std::vector<int> ret;
        for(auto it : intervals){
            auto right = hash.lower_bound(it.end);
            if(right == hash.end()) ret.push_back(-1);
            else ret.push_back(right->second);
        }
        return ret;
    }
};
