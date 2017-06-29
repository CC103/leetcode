public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String arr1[] = a.split("\\+");
        int x1 = Integer.valueOf(arr1[0]);
        int y1 = Integer.valueOf(arr1[1].substring(0, arr1[1].length() - 1));

        String arr2[] = b.split("\\+");
        int x2 = Integer.valueOf(arr2[0]);
        int y2 = Integer.valueOf(arr2[1].substring(0, arr2[1].length() - 1));

        int x = x1 * x2 - y1 * y2;
        int y = x1 * y2 + y1 * x2;

        return x + "+" + y + "i";

    }
}
