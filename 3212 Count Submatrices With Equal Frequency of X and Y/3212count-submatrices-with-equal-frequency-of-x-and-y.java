class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] px = new int[m][n];     // count of X
        int[][] py = new int[m][n];     // count of Y

        int ans = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int isX = grid[i][j] == 'X' ? 1 : 0;
                int isY = grid[i][j] == 'Y' ? 1 : 0;

                px[i][j] = isX;
                py[i][j] = isY;

                if(i > 0) {
                    px[i][j] += px[i-1][j];
                    py[i][j] += py[i-1][j];
                }

                if(j > 0) {
                    px[i][j] += px[i][j-1];
                    py[i][j] += py[i][j-1];
                }

                if(i > 0 && j > 0) {
                    px[i][j] -= px[i-1][j-1];
                    py[i][j] -= py[i-1][j-1];
                }

                if(px[i][j] > 0 && px[i][j] == py[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
} 