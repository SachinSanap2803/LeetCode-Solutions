// 1] Using Recursion
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int l1 = text1.length();
//         int l2 = text2.length();

//         return LCS(text1, text2, l1, l2);
//     }

//     public int LCS(String s1, String s2, int l1, int l2) {
//         if(l1 == 0 || l2 == 0) {
//             return 0;
//         }

//         if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
//             return 1 + LCS(s1, s2, l1-1, l2-1);
//         } else {
//             return Math.max(LCS(s1, s2, l1-1, l2), LCS(s1, s2, l1, l2-1));
//         }
//     }
// }




// 2] Using Memoization - DP
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int l1 = text1.length();
//         int l2 = text2.length();

//         int[][] dp = new int[l1+1][l2+1];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         return LCS(text1, text2, l1, l2, dp);
//     }

//     public int LCS(String s1, String s2, int l1, int l2, int[][] dp) {
//         if(dp[l1][l2] != -1) {
//             return dp[l1][l2];
//         }

//         if(l1 == 0 || l2 == 0) {
//             return 0;
//         }

//         if(s1.charAt(l1-1) == s2.charAt(l2-1)) {
//             dp[l1][l2] = 1 + LCS(s1, s2, l1-1, l2-1, dp);
//         } else {
//             dp[l1][l2] = Math.max(LCS(s1, s2, l1-1, l2, dp), LCS(s1, s2, l1, l2-1, dp));
//         }

//         return dp[l1][l2];
//     }
// }




// 3] Tabulation - DP
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1+1][l2+1];
        
        for(int i=1; i<=l1; i++) {
            for(int j=1; j<=l2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[l1][l2];
    }
} 