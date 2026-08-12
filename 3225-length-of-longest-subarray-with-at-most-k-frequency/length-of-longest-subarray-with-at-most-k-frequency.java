class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int maxi = 0;
        int left = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int right = 0; right < n; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while(freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left])-1);
                left++;
            }

            maxi = Math.max(maxi, right - left + 1);
        }

        return maxi;
    }
} 