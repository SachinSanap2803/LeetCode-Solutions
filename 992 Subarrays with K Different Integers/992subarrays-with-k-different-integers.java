// Brute force

// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         int n = nums.length;
//         int maxCnt = 0;

//         for(int i=0; i<n; i++) {
//             HashMap<Integer, Integer> map = new HashMap<>();

//             for(int j=i; j<n; j++) {
//                 map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

//                 if(map.size() > k) {
//                     break;
//                 }

//                 if(map.size() == k) {
//                     maxCnt += 1;
//                 }
//             }
//         }

//         return maxCnt;
//     }
// } 










// Optimal Solution


class Solution {

    private int cntSubarraysWithLessThanEqualK(int[] arr, int k) {
        int n = arr.length;
        int maxi = 0;
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while(map.size() > k) {
                map.put(arr[l], map.get(arr[l]) - 1);

                if(map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }

                l++;
            }
            
            maxi += r-l+1;

            r++;
        }

        return maxi;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return cntSubarraysWithLessThanEqualK(nums, k) - cntSubarraysWithLessThanEqualK(nums, k-1);
    }
} 