import java.util.*;

public class Twitter {
    private static int time = 0;
    Map<Integer, User> userMap;

    public class User {
        int id;
        Set<Integer> followees;
        Tweet tweetHead;

        User(int id) {
            this.id = id;
            followees = new HashSet<>();
            // follow itself
            followees.add(id);
            tweetHead = null;
        }

        public void follow(int id) {
            followees.add(id);
        }

        public void unfollow(int id) {
            followees.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    private class Tweet {
        int id;
        int timestamp;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            timestamp = time++;
            next = null;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) userMap.put(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user;
        List<Integer> feed = new ArrayList<>();
        if (userMap.containsKey(userId)) user = userMap.get(userId);
        else return feed;

        PriorityQueue<Tweet> queue = new PriorityQueue<>(user.followees.size(), (a, b) -> (b.timestamp - a.timestamp));
        for (int uid: user.followees) {
            Tweet t = userMap.get(uid).tweetHead;
            if (t != null) queue.add(t);
        }

        int limit = 0;
        while (!queue.isEmpty() && limit < 10) {
            Tweet latest = queue.poll();
            feed.add(latest.id);
            if (latest.next != null) queue.add(latest.next);

            limit++;
        }

        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        if (!userMap.containsKey(followeeId)) userMap.put(followeeId, new User(followeeId));

        userMap.get(followerId).followees.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
