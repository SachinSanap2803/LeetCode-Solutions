// 1] Brute Force approach:


// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         int[] temp = new int[k];
//         int j=0;

//         for(int i=n-k; i<n; i++) {
//             temp[j] = nums[i];
//             j++;
//         }

//         for(int i=n-k-1; i>=0; i--) {
//             nums[i+k] = nums[i];
//         }

//         for(int i=0; i<temp.length; i++) {
//             nums[i] = temp[i];
//         }
//     }
// } 



// 2] Optimal Solution: 

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        Reverse(nums, n-k, n-1);
        Reverse(nums, 0, n-k-1);
        Reverse(nums, 0, n-1);
    }

    void Reverse(int[] nums, int left, int right) {
        while(left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
} 