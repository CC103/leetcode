class Solution {
public:
    int maxArea(vector<int>& height) {
        int max = 0;
        int low = 0;
        int high = height.size() - 1;
        while(low < high){
            int volume = (high - low) * min(height[low], height[high]);
            max = volume > max ? volume : max;
            if(height[low] < height[high])
                low++;
            else{
                high--;
            }
        }
        return max;
    }
};
