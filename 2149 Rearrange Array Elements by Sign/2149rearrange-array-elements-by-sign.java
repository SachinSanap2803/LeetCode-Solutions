// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int n = nums.length;
//         int[] pos = new int[n/2];
//         int[] neg = new int[n/2];
//         int posIdx = 0;
//         int negIdx = 0;

//         for(int i=0; i<n; i++) {
//             if(nums[i] > 0) {
//                 pos[posIdx++] = nums[i];
//             } else {
//                 neg[negIdx++] = nums[i];
//             }
//         }

//         int[] ans = new int[n];

//         for(int i=0; i<n/2; i++) {
//             ans[2*i] = pos[i];
//             ans[2*i+1] = neg[i];
//         }

//         return ans;
//     }
// } 




class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0;
        int neg = 1;

        for(int num : nums) {
            if(num > 0) {
                ans[pos] = num;
                pos = pos+2;
            } else {
                ans[neg] = num;
                neg = neg+2;
            }
        }

        return ans;
    }
} 