class Solution {
    public int minimumCost(int[] nums, int k) {
        long rem = k;
        long totalOps = 0;

        int[] arr = nums;

        for(int x : arr) {
            if(rem < x) {
                long needed = x - rem;
                long ops = (needed + k - 1) / k;
                totalOps += ops;
                rem += ops * k;
            }

            rem -= x;
        }

        long MOD = 1_000_000_007L;
        long m1 = totalOps;
        long m2 = totalOps + 1;

        if(m1 % 2 == 0) {
            m1 /= 2;
        } else {
            m2 /= 2;
        }

        m1 %= MOD;
        m2 %= MOD;

        long ans = (m1 * m2) % MOD;
        return (int) ans;
    }
} 