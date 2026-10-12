// Brute force

// class Solution {
//     public int resilientSubarray(int[] nums, int k) {
//         int n = nums.length;
//         int maxLen = 1;

//         for(int i=0; i<n; i++) {
//             int sum = 0;

//             for(int j=i; j<n; j++) {
//                 sum += nums[j];

//                 if(isResilient(nums, i, j, sum, k)) {
//                     maxLen = Math.max(maxLen, j-i+1);
//                 }
//             }
//         }

//         return maxLen;
//     }

//     boolean isResilient(int[] nums, int i, int j, int sum, int k) {
//         for(int m=i; m<=j; m++) {
//             if((sum - nums[m]) % k != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }





// Optimal Solution

class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 1;

        for(int i=0; i<n; i++) {
            int rem = nums[i] % k;

            for(int j=i; j<n; j++) {
                if(nums[j] % k != rem) {
                    break;
                }

                int len = j - i + 1;


                if((long) (len - 1) * rem % k == 0) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
} 