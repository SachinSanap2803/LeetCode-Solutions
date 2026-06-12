class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;

        if(n == 1) return cost[0];

        Arrays.sort(cost);

        for(int i=0, j=n-1; i<j; i++, j--) {
            int temp = cost[j];
            cost[j] = cost[i];
            cost[i] = temp;
        }

        int minCost = 0;
        int j = 0;

        for(int i=0; i<n; i++) {
            j = i+1;
            if(j < n) {
                minCost += cost[i] + cost[j];
            } else {
                minCost += cost[i];
            }
            
            j++;
            i = j;
        }

        return minCost;
    }
} 