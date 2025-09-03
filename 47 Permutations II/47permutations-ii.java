class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermuteUnique(nums, ans, 0);

        return ans;
    }

    public void recurPermuteUnique(int[] nums, List<List<Integer>> ans, int idx) {
        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            if(!ans.contains(list)) {
                ans.add(list);
            }
        }

        for(int i=idx; i<nums.length; i++) {
            swap(nums, i, idx);
            recurPermuteUnique(nums, ans, idx+1);
            swap(nums, i ,idx);
        }
    }

    public void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
} 