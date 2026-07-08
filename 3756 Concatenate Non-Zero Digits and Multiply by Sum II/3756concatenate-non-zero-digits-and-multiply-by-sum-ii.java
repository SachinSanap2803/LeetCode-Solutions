// Brute force

// class Solution {
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int[] res = new int[queries.length];
//         int i=0;
//         int MOD = 1_000_000_007;

//         for(int[] query : queries) {
//             long n = Long.parseLong(s.substring(query[0], query[1]+1));

//             long num = 0;
//             long sum = 0;
//             long place = 1;

//             while(n > 0) {
//                 long digit = n % 10;

//                 if(digit != 0) {
//                     num += (digit * place) % MOD;
//                     sum += digit % MOD;
//                     place *= 10 % MOD;
//                 }
                
//                 n /= 10;
//             }

//             res[i++] = (int) ((num * sum) % MOD);
//         }

//         return res;
//     }
// } 





// Better Solution

// class Solution {
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int[] res = new int[queries.length];
//         int MOD = 1_000_000_007;

//         for(int q=0; q<queries.length; q++) {
//             int left = queries[q][0];
//             int right = queries[q][1];

//             long num = 0;
//             long sum = 0;

//             for(int i=left; i<=right; i++) {
//                 int digit = s.charAt(i) - '0';

//                 if(digit != 0) {
//                     num = (num * 10 + digit) % MOD;
//                     sum = (sum + digit) % MOD;
//                 }
//             }
            
//             res[q] = (int) ((num * sum) % MOD);
//         }

//         return res;
//     }
// } 






// Optimal Solution

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007;
        int n = s.length();

        long[] prefixNum = new long[n+1];
        long[] prefixSum = new long[n+1];
        int[] nonZeroCount = new int[n+1];
        long[] pow10 = new long[n+1];

        pow10[0] = 1;

        for(int i=1; i<=n; i++) {
            pow10[i] = (pow10[i-1] * 10) % MOD;
        }

        for(int i=0; i<n; i++) {
            int digit = s.charAt(i) - '0';

            prefixSum[i+1] = prefixSum[i] + digit;
            nonZeroCount[i+1] = nonZeroCount[i];
            
            if(digit != 0) {
                prefixNum[i+1] = (prefixNum[i] * 10 + digit) % MOD;
                nonZeroCount[i+1]++;
            } else {
                prefixNum[i+1] = prefixNum[i];
            }
        }

        int[] res = new int[queries.length];

        for(int q=0; q<queries.length; q++) {
            int left = queries[q][0];
            int right = queries[q][1];

            long sum = (prefixSum[right+1] - prefixSum[left]) % MOD;
            int digits = nonZeroCount[right+1] - nonZeroCount[left];
            long num = (prefixNum[right+1] - (prefixNum[left] * pow10[digits]) % MOD + MOD) % MOD;

            res[q] = (int) ((num * sum) % MOD);
        }

        return res;
    }
} 