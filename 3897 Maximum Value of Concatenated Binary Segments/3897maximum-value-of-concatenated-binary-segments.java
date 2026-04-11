class Solution {
    static final long MOD = 1_000_000_007L;

    private long pow2(long exp) {
        long res = 1, base = 2;
        while(exp > 0) {
            if((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
             exp >>= 1;
        }

        return res;
    }

    private int compare(int i, int j, int[] nums1, int[] nums0) {
        int a = nums1[i], b = nums0[i];
        int c = nums1[j], d = nums0[j];

        int len = a + b + c + d;

        for(int k=0; k<len; k++) {
            int x = getBit(k, a, b, c, d);
            int y = getBit(k, c, d, a, b);

            if(x != y) {
                return y - x;
            }
        }

        return 0;
    }

    private int getBit(int k, int a, int b, int c, int d) {
        if(k < a) return 1;
        if(k < a + b) return 0;
        k -= (a + b);
        if(k < c) return 1;
        
        return 0;
    }
    
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;

        Integer[] idx = new Integer[n];
        for(int i=0; i<n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> compare(a, b, nums1, nums0));

        long ans = 0;

        for(int i : idx) {
            int ones = nums1[i];
            int zeros = nums0[i];

            long len = ones + zeros;

            ans = (ans * pow2(len)) % MOD;

            long seg = (pow2(ones) - 1 + MOD) % MOD;
            seg = (seg * pow2(zeros)) % MOD;

            ans = (ans + seg) % MOD;
        }

        return (int) ans;
    }
} 