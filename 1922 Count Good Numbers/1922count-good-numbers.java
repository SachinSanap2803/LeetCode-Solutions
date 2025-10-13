// Brute force : TLE

// class Solution {
//     static final int MOD = 1_000_000_007;

//     public int func(int idx, long n) {
//         if(idx == n) {
//             return 1;
//         }

//         long result = 0;

//         if(idx % 2 == 0) {
//             int[] evenDigits = {0, 2, 4, 6, 8};
//             for(int digit : evenDigits) {
//                 result = (result + func(idx+1, n)) % MOD;
//             }
//         } else {
//             int[] primeDigits = {2, 3, 5, 7};
//             for(int digit : primeDigits) {
//                 result = (result + func(idx+1, n)) % MOD;
//             }
//         }

//         return (int) result % MOD;
//     }

//     public int countGoodNumbers(long n) {
//         return func(0, n);
//     }
// } 






// Optimal Solution

class Solution {
    static final long MOD = 1_000_000_007;

    private long powMod(long base, long exp) {
        long result = 1;
        base = base % MOD;

        while(exp > 0) {
            if((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n+1)/2;
        long oddPositions = n/2;

        long evenPart = powMod(5, evenPositions);
        long oddPart = powMod(4, oddPositions);

        return (int) ((evenPart * oddPart) % MOD);
    }
} 