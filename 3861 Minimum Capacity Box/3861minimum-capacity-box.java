class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int ans = -1;
        int ele = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(capacity[i] >= itemSize && ele > capacity[i]) {
                ans = i;
                ele = capacity[i];
            }
        }

        return ans;
    }
} 