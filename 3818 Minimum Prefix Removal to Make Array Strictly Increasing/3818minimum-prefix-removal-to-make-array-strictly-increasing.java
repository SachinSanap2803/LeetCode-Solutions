class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int temp = -1;

        for(int i=0; i<n-1; i++) {
            if(nums[i] >= nums[i+1]) {
                temp = i;
            }
        }

        return temp+1;
    }
} 