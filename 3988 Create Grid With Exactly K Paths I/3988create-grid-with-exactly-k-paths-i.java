class Solution {
    private int M, N, K;
    private char[][] grid;
    
    public String[] createGrid(int m, int n, int k) {
        M = m;
        N = n;
        K = k;

        grid = new char[M][N];
        for(int i=0; i<M; i++) {
            Arrays.fill(grid[i], '?');
        }

        int[] arr = new int[]{m, n, k};

        grid[0][0] = '.';
        grid[M-1][N-1] = '.';

        if(countPaths() < k) {
            return new String[0];
        }

        if(dfs(0)) {
            String[] result = new String[M];
            for(int i=0; i<M; i++) {
                result[i] = new String(grid[i]);
            }
            return result;
        }

        return new String[0];
    }

    private boolean dfs(int idx) {
        long paths = countPaths();

        if(paths < K) {
            return false;
        }

        if(paths == K) {
            for(int i=0; i<M * N; i++) {
                int r = i/N, c = i%N;
                if(grid[r][c] == '?') {
                    grid[r][c] = '.';
                }
            }

            return true;
        } 

        if(idx == M * N) {
            return false;
        }

        int r = idx / N;
        int c = idx % N;

        if((r == 0 && c == 0) || (r == M-1 && c == N-1)) {
            return dfs(idx+1);
        }

        grid[r][c] = '#';
        if(dfs(idx+1)) {
            return true;
        }

        grid[r][c] = '.';
        if(dfs(idx+1)) {
            return true;
        }

        grid[r][c] = '?';
        return false;
    }

    private long countPaths() {
        if(grid[0][0] == '#' || grid[M-1][N-1] == '#') {
            return 0;
        }

        long[][] dp = new long[M][N];
        dp[0][0] = 1;

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j] == '#') {
                    dp[i][j] = 0;
                    continue;
                }

                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
            }
        }

        return dp[M-1][N-1];
    }
}