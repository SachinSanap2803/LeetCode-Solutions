class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;

        for(int num : nums) {
            String curr = num + "";
            for(char ch : curr.toCharArray()) {
                if(ch - '0' == digit) count++;
            }
        }

        return count;
    }
} 