class Solution {
    public long minCost(String s, int[] cost) {
        long totalCost = 0;
        long[] keepCost = new long[26];

        for(int i=0; i<cost.length; i++) {
            totalCost += cost[i];
            keepCost[s.charAt(i) - 'a'] += cost[i];
        }

        long ans = Long.MAX_VALUE;
        for(int i=0; i<26; i++) {
            ans = Math.min(ans, totalCost - keepCost[i]);
        }

        return ans;
    }
} 