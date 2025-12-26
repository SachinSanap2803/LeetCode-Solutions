class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int count = 0;
        Arrays.sort(happiness);
        int n = happiness.length;

        for(int i=n-1; i>=n-k; i--) {
            int val = Math.max(happiness[i] - count, 0);
            ans += val;
            count++;
        }

        return ans;
    }
} 