public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;

        String arr[] = s.split(" ");
        if(arr.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > 0; i--) {
            if(arr[i].length() == 0) continue;
            sb.append(arr[i] + " ");
        }

        if(arr[0].length() == 0) sb.deleteCharAt(sb.length() - 1);
        else sb.append(arr[0]);

        System.out.println(sb.toString());
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseWords(" ");

    }
}
