class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int i = 0, j = 1, sum = 0;
        int size = numbers.size();
        bool flag = false;
        while(1){
            //cout << "i: " << i << "     " << "j: " << j << endl;
            sum = numbers[i] + numbers[j];
            if(sum == target)
                break;
            if(sum > target){
                flag = true;
                j--;
            }
            else if(sum < target){
                if(!flag){
                    j++;
                    if(j == size - 1)
                        flag = true;
                }
                else{
                    i++;
                    flag = false;
                }

            }
        }
        vector<int> ret(2);
        ret[0] = i + 1;
        ret[1] = j + 1;
        return ret;
    }
};
