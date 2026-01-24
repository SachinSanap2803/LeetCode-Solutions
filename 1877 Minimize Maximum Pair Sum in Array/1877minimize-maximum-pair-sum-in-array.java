class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n-1;
        int max = Integer.MIN_VALUE;

        while(left < right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }

        return max;
    }
} 