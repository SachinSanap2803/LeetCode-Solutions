class Solution {
    public int minMergedInteger(int[] nums) {
        int j = 0;

        for(int i=0; i<nums.length-1; i+=2) {
            int num1 = nums[i];
            int num2 = nums[i+1];

            nums[j++] = Integer.parseInt(String.valueOf(num1) + String.valueOf(num2));
        }

        int mini = nums[0];
        for(int i=1; i<nums.length/2; i++) {
            mini = Math.min(mini, nums[i]);
        }

        return mini;
    }
} 