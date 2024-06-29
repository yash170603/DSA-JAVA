import java.util.*;

class Twitter {
    private static class Tweet {
        int userId;
        int tweetId;
        int index;

        Tweet(int userId, int tweetId, int index) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.index = index;
        }
    }

    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollows;
    private int tweetCount;

    public Twitter() {
        userTweets = new HashMap<>();
        userFollows = new HashMap<>();
        tweetCount = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(userId, tweetId, tweetCount++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.index - a.index);
        
        // Add user's own tweets to the priority queue
        if (userTweets.containsKey(userId)) {
            pq.addAll(userTweets.get(userId));
        }

        // Add followed users' tweets to the priority queue
        if (userFollows.containsKey(userId)) {
            for (int followeeId : userFollows.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    pq.addAll(userTweets.get(followeeId));
                }
            }
        }

        // Fetch the top 10 tweets from the priority queue
        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            newsFeed.add(pq.poll().tweetId);
            count++;
        }
        
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return; // A user cannot follow themselves
        }
        userFollows.putIfAbsent(followerId, new HashSet<>());
        userFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            userFollows.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId, tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId, followeeId);
 * obj.unfollow(followerId, followeeId);
 */
