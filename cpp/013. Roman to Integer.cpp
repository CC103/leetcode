class Solution {
public:
    int romanToInt(string s) {
        int sum = 0;
        if(s.find("IV") != std::string::npos){sum-=2;}
        if(s.find("IX") != std::string::npos){sum-=2;}
        if(s.find("XL") != std::string::npos){sum-=20;}
        if(s.find("XC") != std::string::npos){sum-=20;}
        if(s.find("CD") != std::string::npos){sum-=200;}
        if(s.find("CM") != std::string::npos){sum-=200;}

        for(auto i : s){
            if(i =='M') sum+=1000;
            if(i =='D') sum+=500;
            if(i =='C') sum+=100;
            if(i =='L') sum+=50;
            if(i =='X') sum+=10;
            if(i =='V') sum+=5;
            if(i =='I') sum+=1;
           
        }
        return sum;
    }
};
