// class Solution {
//     public String longestPalindrome(String s) {
//         int maxLen = 0;
//         String sb = "";

//         for(int i=0; i<s.length(); i++) {
//             for(int j=i; j<s.length(); j++) {
//                 String sub = s.substring(i, j+1);
//                 if(isPalindrome(sub) && sub.length() > maxLen) {
//                     sb = sub;
//                     maxLen = sub.length();
//                 }
//             }
//         }

//         return sb.toString();
//     }

//     public boolean isPalindrome(String s) {
//         int left = 0;
//         int right = s.length()-1;

//         while(left < right) {
//             if(s.charAt(left) != s.charAt(right)) {
//                 return false;
//             }

//             left++;
//             right--;
//         }

//         return true;
//     }
// }





class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        // All substrings of length 1 are palindrome
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        // check substrings of length 2
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // check substrings of len >= 3
        for(int len = 3; len <= n; len++) {
            for(int i=0; i+len-1<n; i++) {
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start+maxLen);
    }
} 