// 1) Using HashMap

// class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for(int key : map.keySet()) {
//             if(map.get(key) == 1) {
//                 return key;
//             }
//         }

//         return -1;
//     }
// } 







// 2) Using Bit Manipulation

// class Solution {
//     public int singleNumber(int[] nums) {
//         int ans = 0;
//         int n = nums.length;

//         for(int bitIdx = 0; bitIdx < 32; bitIdx++) {
//             int cnt = 0;
//             for(int i=0; i<n; i++) {
//                 if((nums[i] & (1 << bitIdx)) != 0) {
//                     cnt++;
//                 }
//             }

//             if(cnt % 3 != 0) {
//                 ans = ans | (1 << bitIdx);
//             }
//         }

//         return ans;
//     }
// } 







// 3) Using Sorting Solution

// class Solution {
//     public int singleNumber(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         for(int i=1; i<n; i=i+3) {
//             if(nums[i] != nums[i-1]) {
//                 return nums[i-1];
//             }
//         }

//         return nums[n-1];
//     }
// } 







// 4) Optimal Solution

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int i=0; i<nums.length; i++) {
            ones = (ones ^ nums[i]) & ~(twos);
            twos = (twos ^ nums[i]) & ~(ones);
        }

        return ones;
    }
} 