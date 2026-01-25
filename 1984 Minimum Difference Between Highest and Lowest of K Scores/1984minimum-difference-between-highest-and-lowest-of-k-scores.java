class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;

        Arrays.sort(nums);

        int n = nums.length;
        int mini = Integer.MAX_VALUE;

        for(int i=0; i<=n-k; i++) {
            mini = Math.min(mini, nums[i+k-1] - nums[i]);
        }

        return mini;
    }
} 