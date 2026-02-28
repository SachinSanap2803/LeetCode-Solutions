// Brute force

// class Solution {
//     public int concatenatedBinary(int n) {
//         StringBuilder sb = new StringBuilder();

//         for(int i=1; i<=n; i++) {
//             sb.append(Integer.toBinaryString(i));
//         }

//         long result = 0;
//         long MOD = 1_000_000_007;

//         for(int i=0; i<sb.length(); i++) {
//             result = (result * 2 + (sb.charAt(i) - '0')) % MOD;
//         }

//         return (int) result;
//     }
// } 






// Better Solution

// class Solution {
//     public int concatenatedBinary(int n) {
//         long result = 0;
//         long MOD = 1_000_000_007;

//         for(int i=1; i<=n; i++) {
//             int len = Integer.toBinaryString(i).length();

//             result = ((result << len) + i) % MOD;
//         }

//         return (int) result;
//     }
// } 







// Optimal Solution

class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        long MOD = 1_000_000_007;
        long bitLength = 0;

        for(int i=1; i<=n; i++) {
            if((i & (i-1)) == 0) {
                bitLength++;
            }

            result = ((result << bitLength) + i) % MOD;
        }

        return (int) result;
    }
} 