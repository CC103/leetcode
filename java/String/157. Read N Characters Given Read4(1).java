/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] temp = new char[4];
        boolean isEnd = false;

        while (!isEnd && total < n) {
            int num = read4(temp);
            isEnd = num < 4;

            int count = Math.min(num, n - total);
            for (int i = 0; i < count; i++, total++) {
                buf[total] = temp[i];
            }
        }

        return total;
    }
}
