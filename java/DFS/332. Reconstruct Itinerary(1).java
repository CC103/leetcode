import java.util.*;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // add all destinations for each departure
        for (String[] ticket: tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        List<String> route = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        stack.push("JFK");

        while (!stack.empty()) {
            // there is another edge
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                String transfer = stack.peek();
                // least lexical
                stack.push(map.get(transfer).poll());
            }

            route.add(0, stack.pop());
        }

        return route;


    }
}
