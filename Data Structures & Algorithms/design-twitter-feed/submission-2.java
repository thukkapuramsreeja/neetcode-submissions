

class Twitter {

    int time = 0;

    Map<Integer, Set<Integer>> follow = new HashMap<>();
    Map<Integer, List<int[]>> tweets = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add followees' tweets
        for (int id : follow.getOrDefault(userId, new HashSet<>())) {
            if (tweets.containsKey(id)) {
                pq.addAll(tweets.get(id));
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll()[1]);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        // Don't allow self-follow
        if (followerId == followeeId) {
            return;
        }

        follow.putIfAbsent(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}