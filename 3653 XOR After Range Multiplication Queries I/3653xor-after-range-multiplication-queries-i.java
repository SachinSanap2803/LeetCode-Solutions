class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;

        for(int[] q : queries) {
            int idx = q[0], Ri = q[1], Ki = q[2], Vi = q[3];

            while(idx <= Ri) {
                nums[idx] = (int) ((1L * nums[idx] * Vi) % MOD);
                idx += Ki;
            }
        }

        int xor = 0;

        for(int num : nums) {
            xor ^= num;
        }

        return xor;
    }
} 