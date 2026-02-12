// Brute force

// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;

//         for(int i=0; i<n; i++) {
//             int oddCnt = 0;
//             for(int j=i; j<n; j++) {
//                 if(nums[j] % 2 == 1) oddCnt++;
//                 if(oddCnt == k) cnt++;
//                 if(oddCnt > k)  break;
//             }
//         }

//         return cnt;
//     }
// } 







// Better Solution

// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int n = nums.length;

//         int cnt = 0, oddCnt = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         map.put(0, 1);
        
//         for(int i=0; i<n; i++) {
//             oddCnt += nums[i] % 2;
//             int rem = oddCnt - k;

//             if(map.containsKey(rem)) {
//                 cnt += map.get(rem);
//             }

//             map.put(oddCnt, map.getOrDefault(oddCnt, 0) + 1);
//         }

//         return cnt;
//     }
// } 









// Optimal Solution

class Solution {

    private int cntSubarraysWithLessThanEqual(int[] nums, int k) {
        if(k < 0) return 0;

        int n = nums.length;
        int l = 0, r = 0, oddCnt = 0, cnt = 0;

        while(r < n) {
            oddCnt += nums[r] % 2;
            
            while(oddCnt > k) {
                oddCnt -= (nums[l] % 2);
                l++;
            }

            cnt += (r - l + 1);
            r++;
        }

        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int cnt1 = cntSubarraysWithLessThanEqual(nums, k);
        int cnt2 = cntSubarraysWithLessThanEqual(nums, k-1);

        return cnt1 - cnt2;
    }
} 