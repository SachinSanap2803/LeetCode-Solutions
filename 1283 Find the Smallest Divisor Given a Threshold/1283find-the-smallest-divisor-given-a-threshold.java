// class Solution {
//     public int smallestDivisor(int[] nums, int threshold) {
//         int n = nums.length;
//         int max = Integer.MIN_VALUE;

//         for(int num : nums) {
//             if(num > max) {
//                 max = num;
//             }
//         }

//         for(int d=1; d<=max; d++) {
//             if(isTrue(nums, d, threshold)) {
//                 return d;
//             }
//         }

//         return -1;
//     }

//     public boolean isTrue(int[] arr, int k, int target) {
//         int sum = 0;
//         for(int num : arr) {
//             sum += (num + (k-1)) / k;

//             if(sum > target) {
//                 return false;
//             }
//         }

//         return sum <= target;
//     }
// } 





class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        int left = 1, right = max;
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(isTrue(nums, mid, threshold)) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public boolean isTrue(int[] arr, int k, int target) {
        int sum = 0;
        for(int num : arr) {
            sum += (num + (k-1)) / k;

            if(sum > target) {
                return false;
            }
        }

        return sum <= target;
    }
} 