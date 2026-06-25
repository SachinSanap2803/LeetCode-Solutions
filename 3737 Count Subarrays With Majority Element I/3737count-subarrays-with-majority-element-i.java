class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int currCnt = 0;
            for(int j=i; j<n; j++) {
                if(nums[j] == target) {
                    currCnt++;
                }

                int len = j-i+1;
                if(currCnt > len/2) ans++;
            }
        }

        return ans;
    }
} 