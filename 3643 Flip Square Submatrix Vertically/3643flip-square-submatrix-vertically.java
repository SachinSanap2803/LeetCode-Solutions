class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(x < 0 || y < 0 || x >= m || y >= n) {
            return grid;
        }
        
        if(k <= 0 || k > Math.min(m-x, n-y)) {
            return grid;
        }
        
        for(int i=0; i<k/2; i++) {
            int rowTop = x+i;
            int rowBottom = x+k-1-i;

            for(int col=y; col<y+k; col++) {
                int temp = grid[rowTop][col];
                grid[rowTop][col] = grid[rowBottom][col];
                grid[rowBottom][col] = temp;
            }
        }

        return grid;
    }
} 