class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;     // It is a Maximum Bitwise AND
        
        for(int num : nums) {
            max = Math.max(max, num);
        }

        int curr = 0;
        int longest = 0;

        for(int num : nums) {
            if(num == max) {
                curr ++;
                longest = Math.max(longest, curr);
            } else {
                curr = 0;
            }
        }

        return longest;
    }
}