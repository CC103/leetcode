class Solution {
public:
    int maxArea(vector<int>& height) {
        int max = 0;
        int volume;
        int size = height.size();
        int leftHighest = height[0];
        int rightHighest;
        for(int i = 0; i < size; i++){
            if(height[i] < leftHighest)
                continue;
            leftHighest = height[i];
            rightHighest = height[size - 1];
            for(int j = size - 1; j > i; j--){
                if(height[j] < rightHighest)
                    continue;
                rightHighest = height[j];
                volume = (j - i) * min(height[i], height[j]);
                max = volume > max ? volume : max;
            }
        }
        return max;
    }
};
