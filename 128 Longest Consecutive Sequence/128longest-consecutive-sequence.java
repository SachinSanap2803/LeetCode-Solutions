// 1] Brute force approach

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int longest = 1;
//         int n = nums.length;

//         for(int i=0; i<n; i++) {
//             int x = nums[i];
//             int count = 1;

//             while(searchNext(nums, x+1)) {
//                 x = x + 1;
//                 count = count + 1;
//             }

//             longest = Math.max(longest, count);
//         }

//         return longest;
//     }

//     private boolean searchNext(int[] nums, int num) {
//         for(int i=0; i<nums.length; i++) {
//             if(nums[i] == num) {
//                 return true;
//             }
//         }

//         return false;
//     }
// } 




// 2] Better approach

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Arrays.sort(nums);
//         int longest = 1;
//         int count = 0;
//         int lastSmaller = Integer.MIN_VALUE;

//         for(int i=0; i<nums.length; i++) {
//             if(nums[i]-1 == lastSmaller) {
//                 count = count+1;
//                 lastSmaller = nums[i];
//             } else if(lastSmaller != nums[i]) {
//                 count = 1;
//                 lastSmaller = nums[i];
//             }

//             longest = Math.max(longest, count);
//         }

//         return longest;
//     }
// }



// 3] Optimal Solution

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(nums[i]);
        }

        for(int num : set) {
            if(!set.contains(num-1)) {
                int count = 1;
                int x = num;

                while(set.contains(x+1)) {
                    count = count + 1;
                    x = x + 1;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
} 