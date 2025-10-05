class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean isAllZero = true;
        int n = nums.length;

        for(int num : nums) {
            xor ^= num;
            if(num != 0) {
                isAllZero = false;
            }
        }

        if(xor != 0) return n;
        if(isAllZero) return 0;
        return n-1;
    }
} 