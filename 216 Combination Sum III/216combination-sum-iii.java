class Solution {

    private void findCombinations(int target, int k, int idx, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0 && ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(target <= 0 || ds.size() > k) return;

        for(int i=idx; i<=9; i++) {
            if(i <= target) {
                ds.add(i);
                findCombinations(target - i, k, i+1, ans, ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(n, k, 1, ans, new ArrayList<>());
        return ans;
    }
} 