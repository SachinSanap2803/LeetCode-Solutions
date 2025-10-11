class Solution {

    public void calSubsets(int[] nums, List<Integer> temp, List<List<Integer>> ans, int idx) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        calSubsets(nums, temp, ans, idx+1);
        temp.remove(temp.size()-1);
        calSubsets(nums, temp, ans, idx+1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        calSubsets(nums, new ArrayList<>(), ans, 0);

        return ans;
    }
} 