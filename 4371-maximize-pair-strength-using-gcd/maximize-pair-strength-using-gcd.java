class Solution {
    public long maxPairStrength(int[] nums) {
        long maxi = 0;
        int n = nums.length;

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int g = gcd(nums[i], nums[j]);
                long strength = (1L * nums[i] * nums[j]) / (1L * g * g);
                maxi = Math.max(maxi, strength);
            }
        }

        return maxi;
    }

    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
} 