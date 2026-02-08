class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] postSum = new int[n];

        postSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            postSum[i] = postSum[i+1] + nums[i];
        }

        int ans = 0;
        
        for(int i=0; i<n-1; i++) {
            if(nums[i] > postSum[i+1]/(n-i-1)) {
                ans++;
            }
        }

        return ans;
    }
} 