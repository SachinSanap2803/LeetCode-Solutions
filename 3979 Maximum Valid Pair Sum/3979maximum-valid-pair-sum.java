// Brute force

// class Solution {
//     public int maxValidPairSum(int[] nums, int k) {
//         int n = nums.length;
//         int maxi = 0;

//         for(int i=0; i<n; i++) {
//             for(int j=i; j<n; j++) {
//                 if(j-i >= k) {
//                     maxi = Math.max(maxi, nums[i] + nums[j]);
//                 }
//             }
//         }

//         return maxi;
//     }
// } 




// Optimized solution

class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int maxLeft = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int j=k; j<nums.length; j++) {
            maxLeft = Math.max(maxLeft, nums[j-k]);
            ans = Math.max(ans, maxLeft + nums[j]);
        }

        return ans;
    }
} 