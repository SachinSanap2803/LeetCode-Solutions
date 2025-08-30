// 1] Linear Search

// class Solution {
//     public int splitArray(int[] nums, int k) {
//         int n = nums.length;
//         int max = Integer.MIN_VALUE;;
//         int sum = 0;

//         if(n < k) {
//             return -1;
//         }

//         for(int num : nums) {
//             if(num > max) {
//                 max = num;
//             }
//             sum += num;
//         }

//         int low = max, high = sum;
//         for(int i=low; i<=high; i++) {
//             int count = findSum(nums, i);
//             if(count == k) {
//                 return i;
//             }
//         }

//         return -1;
//     }

//     public int findSum(int[] nums, int sum) {
//         int count = 1, currSum = 0;
//         for(int i=0; i<nums.length; i++) {
//             if(nums[i] + currSum <= sum) {
//                 currSum += nums[i];
//             } else {
//                 count++;
//                 currSum = nums[i];
//             }
//         }

//         return count;
//     }
// } 





// 2] Binary Search

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;;
        int sum = 0;

        if(n < k) {
            return -1;
        }

        for(int num : nums) {
            if(num > max) {
                max = num;
            }
            sum += num;
        }

        int low = max, high = sum;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(findSum(nums, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int findSum(int[] nums, int sum) {
        int count = 1, currSum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] + currSum <= sum) {
                currSum += nums[i];
            } else {
                count++;
                currSum = nums[i];
            }
        }

        return count;
    }
} 