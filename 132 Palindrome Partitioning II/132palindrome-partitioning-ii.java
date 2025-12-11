class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];

        // Precompute all palindromes
        for(int len=1; len<=n; len++) {
            for(int i=0; i+len-1<n; i++) {
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j)) {
                    if(len <= 2) {
                        pal[i][j] = true;
                    } else {
                        pal[i][j] = pal[i+1][j-1];
                    }
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // DP from right to left
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(pal[i][j]) {
                    if(j == n-1) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], 1+dp[j+1]);
                    }
                }
            }
        }

        return dp[0];
    }
} 