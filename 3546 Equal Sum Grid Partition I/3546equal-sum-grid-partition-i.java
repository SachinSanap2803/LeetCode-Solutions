class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long totalSum = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                totalSum += grid[i][j];
            }
        }

        if(totalSum % 2 != 0) return false;

        long target = totalSum / 2;

        // Horizontal cut
        long curr = 0;
        for(int i=0; i<m-1; i++) {
            long rowSum = 0;
            for(int j=0; j<n; j++) {
                rowSum += grid[i][j];
            }

            curr += rowSum;
            if(curr == target) return true;
        }

        // Vertical cut
        curr = 0;
        for(int j=0; j<n-1; j++) {
            long colSum = 0;
            for(int i=0; i<m; i++) {
                colSum += grid[i][j];
            }

            curr += colSum;
            if(curr == target) return true;
        }

        return false;
    }
} 