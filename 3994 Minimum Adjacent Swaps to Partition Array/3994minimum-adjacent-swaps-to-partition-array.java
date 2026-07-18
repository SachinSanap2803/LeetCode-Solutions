class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        final int MOD = 1_000_000_007;

        long seenM = 0;
        long seenH = 0;
        long ans = 0;

        for(int num : nums) {
            if(num < a) {
                ans += seenM + seenH;
            } else if(num >= a && num <= b) {
                ans += seenH;
                seenM++;
            } else {
                seenH++;
            }
        }

        return (int) (ans % MOD);
    }
} 