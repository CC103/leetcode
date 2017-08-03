/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int bufPointer = 0;
    int bufCount = 0;
    char[] temp = new char[4];

    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (bufPointer == 0) bufCount = read4(temp);
            if (bufCount == 0) break;
            while (total < n && bufPointer < bufCount) {
                buf[total++] = temp[bufPointer++];
            }
            if (bufPointer == bufCount) bufPointer = 0;
        }

        return total;
    }
}
