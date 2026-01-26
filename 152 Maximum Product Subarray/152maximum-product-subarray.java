// Brute force

// class Solution {
//     public int maxProduct(int[] nums) {
//         int ans = Integer.MIN_VALUE;
//         int n = nums.length;

//         for(int i=0; i<n; i++) {
//             int temp = 1;
//             for(int j=i; j<n; j++) {
//                 temp *= nums[j];
//                 ans = Math.max(ans, temp);
//             }
//         }

//         return ans;
//     }
// } 







// Optimal Solution

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for(int i=0; i<n; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n-i-1];

            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }

        return maxi;
    }
} 