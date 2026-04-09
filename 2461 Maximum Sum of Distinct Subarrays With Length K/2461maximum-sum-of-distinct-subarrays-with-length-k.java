class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long maxi = 0, currSum = 0;

        int l = 0, r = 0;

        while(r < n) {
            currSum += nums[r];
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            if(r - l + 1 == k) {
                if(map.size() == k) {
                    maxi = Math.max(maxi, currSum);
                }

                currSum -= nums[l];

                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }

                l++;
            }

            r++;
        }

        return maxi;
    }
} 