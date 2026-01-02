// Solution 1

// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for(int key : map.keySet()) {
//             if(map.get(key) > 1) {
//                 return key;
//             }
//         }

//         return -1;
//     }
// } 





// Solution 2

// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int num : nums) {
//             if(!set.add(num)) {
//                 return num;
//             }
//         }

//         return -1;
//     }
// } 







// Solution 3

class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=2; i<nums.length; i++) {
            if(nums[i] == nums[i-1] || nums[i] == nums[i-2]) {
                return nums[i];
            }
        }

        return nums[0];
    }
} 