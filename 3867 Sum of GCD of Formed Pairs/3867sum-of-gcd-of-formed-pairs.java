class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int maxi = 0;

        for(int i=0; i<n; i++) {
            maxi = Math.max(maxi, nums[i]);
            prefixGcd[i] = gcd(maxi, nums[i]);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int l = 0, r = n-1;

        while(l < r) {
            sum += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }

        return sum;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }
} 