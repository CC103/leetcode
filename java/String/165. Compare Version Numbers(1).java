public class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for(int i = 0 ; i < len; i++) {
            int ver1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int ver2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;

            if(ver1 == ver2) continue;
            else return ver1 < ver2 ? -1 : 1;
        }

        return 0;

    }

}
