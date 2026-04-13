class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int mini = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                mini = Math.min(mini, Math.abs(i - start));
            }
        }

        return mini;
    }
} 