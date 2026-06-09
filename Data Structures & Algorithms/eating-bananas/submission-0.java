
class Solution {

    private long getHours(int[] piles, int k) {
        long hours = 0;

        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil division
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int p : piles) {
            high = Math.max(high, p);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (getHours(piles, mid) <= h) {
                ans = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}