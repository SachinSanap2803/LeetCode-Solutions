// 1) Brute force

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] ans = new int[m+n];
//         int left=0, right=0, idx=0;
        
//         while(left<m && right<n) {
//             if(nums1[left] <= nums2[right]) {
//                 ans[idx++] = nums1[left];
//                 left++;
//             } else {
//                 ans[idx++] = nums2[right];
//                 right++;
//             }
//         }

//         while(left<m) {
//             ans[idx++] = nums1[left++];
//         }

//         while(right<n) {
//             ans[idx++] = nums2[right++];
//         }

//         idx=0;
//         while(idx<m+n) {
//             nums1[idx] = ans[idx];
//             idx++;
//         }
//     }
// } 







// Optimal Solution

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = n-1;
        int idx = m+n-1;

        while(left >= 0 && right >= 0) {
            if(nums1[left] <= nums2[right]) {
                nums1[idx--] = nums2[right];
                right--;
            } else {
                nums1[idx--] = nums1[left];
                left--;
            }
        }

        while(left >= 0) {
            nums1[idx--] = nums1[left--];
        }

        while(right >= 0) {
            nums1[idx--] = nums2[right--];
        }
    }
} 