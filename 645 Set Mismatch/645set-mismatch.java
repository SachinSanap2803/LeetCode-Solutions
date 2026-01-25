// Solution 1

// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int n = nums.length;

//         int repeated = -1, missing = -1;

//         for(int i=1; i<=n; i++) {
//             int count = 0;
//             for(int j=0; j<n; j++) {
//                 if(nums[j] == i) count++;
//             }

//             if(count == 2) repeated = i;
//             else if(count == 0) missing = i;

//             if(repeated != -1 && missing != -1) {
//                 break;
//             }
//         }

//         return new int[] {repeated, missing};
//     }
// } 






// Solution 2

// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int n = nums.length;
//         int[] freq = new int[n+1];

//         for(int num : nums) {
//             freq[num]++;
//         }

//         int repeated = -1, missing = -1;
//         for(int i=1; i<=n; i++) {
//             if(freq[i] == 2) repeated = i;
//             else if(freq[i] == 0) missing = i;

//             if(repeated != -1 && missing != -1) break;
//         }

//         return new int[] {repeated, missing};
//     }
// } 







// Solution 3

// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int n = nums.length;

//         int xor = 0;
//         for(int i=0; i<n; i++) {
//             xor = xor ^ nums[i];
//             xor = xor ^ (i+1);
//         }

//         int bitNo = 0;
//         while((xor & (1 << bitNo)) == 0) {
//             bitNo++;
//         } 

//         int one = 0;
//         int zero = 0;

//         for(int i=0; i<n; i++) {
//             // part of 1 club
//             if((nums[i] & (1 << bitNo)) != 0) {
//                 one ^= nums[i];
//             } 
//             // part of 0th club
//             else {
//                 zero ^= nums[i];
//             }
//         }

//         for(int i=1; i<=n; i++) {
//             if((i & (1 << bitNo)) != 0) {
//                 one ^= i;
//             } else {
//                 zero ^= i;
//             }
//         }

//         int count = 0;
//         for(int i=0; i<n; i++) {
//             if(nums[i] == zero) {
//                 count++;
//             }
//         }

//         if(count == 2) {
//             return new int[] {zero, one};
//         } else {
//             return new int[] {one, zero};
//         }
//     }
// } 







// Solution 4

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long Sn = (long) n * (n + 1) / 2;
        long S2n = (long) n * (n + 1) * (2L * n + 1) / 6;
        long S = 0, S2 = 0;

        for(int i=0; i<n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * nums[i];
        }

        long val1 = S - Sn;       // x - y
        long val2 = S2 - S2n;     // x^2 - y^2

        val2 = val2 / val1;      // x + y

        long x = (val1 + val2) / 2;     // Repeating
        long y = x - val1;              // Missing

        return new int[] {(int) x, (int) y};
    }
} 