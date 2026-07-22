

class Twitter {

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweetMap.containsKey(userId)) {
            pq.addAll(tweetMap.get(userId));
        }

        Set<Integer> followees =
                followMap.getOrDefault(userId, new HashSet<>());

        for (int followee : followees) {

            if (tweetMap.containsKey(followee)) {

                pq.addAll(tweetMap.get(followee));
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10) {

            ans.add(pq.poll().id);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {

            followMap.get(followerId).remove(followeeId);
        }
    }
}