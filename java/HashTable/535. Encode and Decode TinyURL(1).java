import java.util.HashMap;
import java.util.Map;

public class Codec {
    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = map.size();
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] arr = shortUrl.split("/");
        int id = Integer.valueOf(arr[arr.length - 1]);
        return map.get(id);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
