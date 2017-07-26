import java.util.*;

public class Vector2D implements Iterator<Integer> {
    List<Iterator> its;

    public Vector2D(List<List<Integer>> vec2d) {
        its = new ArrayList<>();
        for (List<Integer> l: vec2d) {
            if (!l.isEmpty()) its.add(l.iterator());
        }
    }

    @Override
    public Integer next() {
        Iterator it = its.get(0);
        int res = (int)it.next();
        its.remove(0);
        if (it.hasNext()) its.add(0, it);
        return res;
    }

    @Override
    public boolean hasNext() {
        return (its.size() != 0);
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
