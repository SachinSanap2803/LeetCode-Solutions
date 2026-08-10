// Brute force

// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();

//         for(int num : nums) {
//             set.add(num);
//         }

//         List<Integer> res = new ArrayList<>();

//         for(int i=1; i<=nums.length; i++) {
//             if(!set.contains(i)) {
//                 res.add(i);
//             }
//         }

//         return res;
//     }
// }





// Optimal Solution

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }

        return res;
    }
}