class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        int n = nums.length;
        Arrays.sort(nums);
        long totalSum = 0;

        for(int i=n-1; i>=0 && k > 0; i--) {
            if(mul > 0) {
                totalSum += (long) nums[i] * mul;
                mul--;
            } else {
                totalSum += nums[i];
            }

            k--;
        }

        return totalSum;
    }
} 