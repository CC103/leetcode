import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

    List<Integer> l;
    int cur = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l = new ArrayList<>();
        int p = 0, q = 0;
        int flag = 0;

        while (p != v1.size() || q != v2.size()) {
            if (p == v1.size()) l.add(v2.get(q++));
            else if (q == v2.size()) l.add(v1.get(p++));
            else {
                if ((flag & 1) == 0) l.add(v1.get(p++));
                else l.add(v2.get(q++));

                flag++;
            }
        }
    }

    public int next() {
        return l.get(cur++);
    }

    public boolean hasNext() {
        return cur < l.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
