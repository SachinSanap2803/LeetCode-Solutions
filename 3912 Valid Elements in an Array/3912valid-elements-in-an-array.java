class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        
        if(n == 1) {
            res.add(nums[0]);
            return res;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
        }

        rightMax[n-1] = Integer.MIN_VALUE;
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }

        for(int i=0; i<n; i++) {
            if(nums[i] > leftMax[i] || nums[i] > rightMax[i]) {
                res.add(nums[i]);
            }
        }

        return res;
    }
} 