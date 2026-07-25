class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Take current element
        curr.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], curr, ans);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Skip current element
        backtrack(index + 1, candidates, target, curr, ans);
    }
}