class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int len = n / 2;

        long total = 0;
        for(int i=0; i<n; i++) {
            total += nums[i];
        }

        long first = 0;
        for(int i=0; i<len; i++) {
            first += nums[i];
        }

        int ans = 0;
        
        if(first > total - first) {
            ans++;
        }

        for(int i=1; i<n; i++) {
            first -= nums[i-1];
            first += nums[(i+len-1) % n];

            if(first > total - first) {
                ans++;
            }
        }

        return ans;
    } 
} 