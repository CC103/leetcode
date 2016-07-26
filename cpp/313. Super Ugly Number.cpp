/*
Core idea: 
任意一个合数都可以被分解为质数的积且super ugly number的所有质因子都在规定集合内
可推导出super ugly number是集合内任意数的乘积
因此一个满足要求的super ugly number不断去除规定集合内的质数，一定可以被整除到1
*/
class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        int size = primes.size();
        vector<int> ret;
        int i = 1;
        //loop until find the nth super ugly number
        while(ret.size() < n){
            int tmp = i;
            bool flag = true;
            //loop until we can determine if i is a super ugly number
            while(flag){
                //keep doing division
                for(int j = 0; j < primes.size(); j++){
                    //if tmp == 1, it means i is product of numbers which are all in "primes"
                    if(tmp == 1){
                        ret.push_back(i);
                        flag = 0;
                        break;
                    }
                    if(tmp % primes[j] == 0){
                        tmp /= primes[j];
                        break;
                    }
                    if(j == primes.size() - 1)
                        flag = false;
                }
            }
            i++;
        }
        return ret[n - 1];
    }
};
