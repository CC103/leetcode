public class Solution {
    public String validIPAddress(String IP) {
        if(IP.length() == 0) return "Neither";

        if(isValidIPv4(IP)) return "IPv4";

        if(isValidIPv6(IP)) return "IPv6";

        return "Neither";

    }

    boolean isValidIPv4(String ip) {
        if(ip.charAt(ip.length() - 1) == '.') return false;

        String ips[] = ip.split("\\.");
        if(ips.length != 4) return false;

        for(String i: ips) {
            if(i.length() == 0 || i.length() > 3) return false;

            for(char c: i.toCharArray()) {
                if(!Character.isDigit(c)) return false;
            }

            if(i.length() != 1 && i.charAt(0) == '0') return false;

            if(Integer.valueOf(i) > 255 || Integer.valueOf(i) < 0) return false;
        }

        return true;
    }

    boolean isValidIPv6(String ip) {
        if(ip.charAt(ip.length() - 1) == ':') return false;
        String chars = "0123456789abcdefABCDEF";

        String ips[] = ip.split(":");
        if(ips.length != 8) return false;

        for(String i: ips) {
            if(i.length() == 0 || i.length() > 4) return false;

            for(char c: i.toCharArray()) {
                if(!chars.contains(c + "")) return false;
            }

        }

        return true;
    }


}
