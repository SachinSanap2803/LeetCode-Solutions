// Brute force

// class Solution {
//     public int maxDistance(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int maxi = 0;

//         for(int i=0; i<n1; i++) {
//             for(int j=n2-1; j>=0; j--) {
//                 if(i > j) {
//                     break;
//                 }

//                 while(i <= j && nums1[i] > nums2[j]) {
//                     j--;
//                 }

//                 if(i <= j && nums1[i] <= nums2[j]) {
//                     maxi = Math.max(maxi, j-i);
//                     break;
//                 }
//             }
//         }

//         return maxi;
//     }
// } 






// Optimal Solution

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxi = 0;
        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                maxi = Math.max(maxi, j-i);
                j++;
            } else {
                i++;
            }
        }

        return maxi;
    }
} 