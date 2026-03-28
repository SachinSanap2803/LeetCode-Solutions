class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                for(int j=0; j<n; j++) {
                    if(nums[j] == 2) {
                        mini = Math.min(mini, Math.abs(i-j));
                    }
                }
            }
        }

        return (mini == Integer.MAX_VALUE) ? -1 : mini;
    }
} 