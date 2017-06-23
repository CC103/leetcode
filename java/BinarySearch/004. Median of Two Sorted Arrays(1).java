public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr1[], arr2[];
        if(nums1.length > nums2.length) {
            arr1 = nums2;
            arr2 = nums1;
        }
        else {
            arr2 = nums2;
            arr1 = nums1;
        }

        // n >= m
        int m = arr1.length;
        int n = arr2.length;
        int q = (m + n + 1) / 2;

        int low = 0, high = m, i, j;
        while(low <= high) {
            i = (low + high) / 2;
            j = q - i;

            if(i < m && arr1[i] < arr2[j - 1]) {
                // too small
                low = i +1;
            }

            else if(i > 0 && arr1[i - 1] > arr2[j]) {
                high = i - 1;
            }

            else {
                double maxOfLeft;
                if(i == 0) maxOfLeft = arr2[j - 1];
                else if(j == 0) maxOfLeft = arr1[i - 1];
                else maxOfLeft = Math.max(arr1[i - 1], arr2[j - 1]);

                if((m + n) % 2 == 1) return maxOfLeft;

                double maxOfRight;
                if(i == m) maxOfRight = arr2[j];
                else if(j == n) maxOfRight = arr1[i];
                else maxOfRight = Math.min(arr2[j], arr1[i]);

                return (maxOfLeft + maxOfRight) / 2;
            }

        }
        return 0.0;

    }
}
