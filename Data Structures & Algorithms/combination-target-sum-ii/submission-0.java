class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int start, int target, int[] arr,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicates
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            // No need to continue
            if (arr[i] > target) {
                break;
            }

            curr.add(arr[i]);

            backtrack(i + 1, target - arr[i], arr, curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}