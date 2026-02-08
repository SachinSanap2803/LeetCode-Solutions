// Brute force

// class Solution {
//     public long countSubarrays(int[] nums, long k) {
//         long count = 0;
//         int n = nums.length;

//         for(int i=0; i<n; i++) {
//             int max = nums[i];
//             int min = nums[i];
//             for(int j=i; j<n; j++) {
//                 max = Math.max(max, nums[j]);
//                 min = Math.min(min, nums[j]);

//                 if((max - min) * (j-i+1) <= k) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// } 





// Optimal Solution

class Solution {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        long count = 0;
        int l = 0;

        for(int r=0; r<nums.length; r++) {
            // maintain max dequeue
            while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
                maxD.pollLast();
            }

            maxD.addLast(r);

            // maintain min dequeue
            while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
                minD.pollLast();
            }

            minD.addLast(r);

            // shrink window if cost > k
            while((long) (nums[maxD.peekFirst()] - nums[minD.peekFirst()]) * (r-l+1) > k) {
                if(maxD.peekFirst() == l) maxD.pollFirst();
                if(minD.peekFirst() == l) minD.pollFirst();
                l++;
            }

            count += (r-l+1);
        }

        return count;
    }
} 