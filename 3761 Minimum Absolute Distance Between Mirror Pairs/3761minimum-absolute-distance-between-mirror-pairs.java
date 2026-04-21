// Brute force

// class Solution {
//     public int minMirrorPairDistance(int[] nums) {
//         int n = nums.length;
//         int mini = Integer.MAX_VALUE;

//         for(int i=0; i<n-1; i++) {
//             for(int j=i+1; j<n; j++) {
//                 if(reverse(nums[i]) == nums[j]) {
//                     mini = Math.min(mini, Math.abs(j-i));
//                     break;
//                 }
//             }
//         }

//         return mini == Integer.MAX_VALUE ? -1 : mini;
//     }

//     private int reverse(int n) {
//         int rev = 0;
//         while(n > 0) {
//             int rem = n % 10;
//             rev = rev * 10 + rem;
//             n = n / 10;
//         }

//         return rev;
//     }
// } 






// Optimal Solution

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                mini = Math.min(mini, i - map.get(nums[i]));
            }

            int rev = reverse(nums[i]);
            map.put(rev, i);
        }

        return mini == Integer.MAX_VALUE ? -1 : mini;
    }

    private int reverse(int n) {
        int rev = 0;
        while(n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }

        return rev;
    }
} 