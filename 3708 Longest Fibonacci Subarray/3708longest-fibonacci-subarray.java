class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int max = 0;

        for(int i=2; i<nums.length; i++) {
            if(nums[i-1] + nums[i-2] == nums[i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max + 2;
    }
} 