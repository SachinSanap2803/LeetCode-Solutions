class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        if(n < 2) return -1;

        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];

        prefixSum[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        suffixSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixSum[i] = suffixSum[i+1] + nums[i];
        }

        boolean[] inc = new boolean[n];
        boolean[] dec = new boolean[n];

        inc[0] = true;
        for(int i=1; i<n; i++) {
            inc[i] = inc[i-1] && nums[i] > nums[i-1];
        }

        dec[n-1] = true;
        for(int i=n-2; i>=0; i--) {
            dec[i] = dec[i+1] && nums[i] > nums[i+1];
        }

        long ans = Long.MAX_VALUE;
        for(int i=0; i<n-1; i++) {
            if(inc[i] && dec[i+1]) {
                long sumLeft = prefixSum[i];
                long sumRight = suffixSum[i+1];

                ans = Math.min(ans, Math.abs(sumLeft - sumRight));
            }
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }
} 