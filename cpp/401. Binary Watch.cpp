class Solution {
public:
    vector<string> readBinaryWatch(int num) {
        int mins[6] = {1, 2, 4, 8, 16, 32};
        int hours[4] = {60, 120, 240, 480};
        vector<int> sums;
        vector<string> strings;
        for(int i = 0; i <= num; i++){
            int minsNum = i;
            int hoursNum = num - i;
            vector<int> minsSums;
            vector<int> hoursSums;
            int minsSum = 0;
            int hoursSum = 0;
            calTotalMins(minsNum, minsSum, 0, mins, minsSums);
            calTotalHours(hoursNum, hoursSum, 0, hours, hoursSums);
            for(auto i : minsSums){
                // min(0-59)
                if(i > 59){
                    continue;
                }
                for(auto j : hoursSums){
                    // hour(0-11)
                    if(j > 660){
                        continue;
                    }
                    int total = i + j;
                    sums.push_back(total);
                }
            }  
        }
        sort(sums.begin(), sums.end());
        for(auto i : sums){
                int hour = i / 60;
                stringstream s1;
                string strHour;
                s1 << hour;
                s1 >> strHour;
                int min = i % 60;
                stringstream s2;
                string strMin;
                s2 << min;
                s2 >> strMin;
                if(min < 10){
                    strMin = "0" + strMin;
                }
                strings.push_back(strHour + ":" + strMin);
            }
        return strings;

    }
    void calTotalMins(int num, int &sum, int start, int *mins, vector<int> &minsSums){
        if(num == 0){
            minsSums.push_back(sum);
            return;
        }
        else{
            for(int i = start; i < 6; i++){
                sum += mins[i];
                calTotalMins(num - 1, sum, i + 1, mins, minsSums);
                sum -= mins[i];
            }
        }
    }
    void calTotalHours(int num, int &sum, int start, int *hours, vector<int> &hoursSums){
        if(num == 0){
            hoursSums.push_back(sum);
            return;
        }
        else{
            for(int i = start; i < 4; i++){
                sum += hours[i];
                calTotalHours(num - 1, sum, i + 1, hours, hoursSums);
                sum -= hours[i];
            }
        }
    }
};
