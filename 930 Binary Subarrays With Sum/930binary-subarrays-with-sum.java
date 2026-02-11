// Brute force

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n = nums.length;
//         int count = 0;

//         for(int i=0; i<n; i++) {
//             int sum = 0;
//             for(int j=i; j<n; j++) {
//                 sum += nums[j];
//                 if(sum > goal) {
//                     break;
//                 }

//                 if(sum == goal) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// } 







// Better Solution

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n = nums.length;
//         int count = 0;
//         int preSum = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();

//         map.put(0, 1);
        
//         for(int i=0; i<n; i++) {
//             preSum += nums[i];

//             int rem = preSum - goal;
//             if(map.containsKey(rem)) {
//                 count += map.get(rem);
//             }

//             map.put(preSum, map.getOrDefault(preSum, 0) + 1);
//         }

//         return count;
//     }
// } 









// Optimal Solution

class Solution {

    private int cntSubarrayWithLessThanEqual(int[] nums, int goal) {
        if(goal < 0) return 0;
        
        int n = nums.length;
        int count = 0, l = 0, r = 0, sum = 0;

        while(r < n) {
            sum += nums[r];

            while(sum > goal) {
                sum = sum - nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt1 = cntSubarrayWithLessThanEqual(nums, goal);
        int cnt2 = cntSubarrayWithLessThanEqual(nums, goal-1);

        return cnt1 - cnt2;
    }
} 