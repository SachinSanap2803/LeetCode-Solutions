class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;

        for(int p=1; p<n-2; p++) {
            for(int q = p+1; q<n-1; q++) {
                if(isStrInc(nums, 0, p) && isStrDec(nums, p, q) && isStrInc(nums, q, n-1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isStrInc(int[] nums, int start, int end) {
        if(end - start < 1) return false;
        
        for(int i=start; i<end; i++) {
            if(nums[i] >= nums[i+1]) {
                return false;
            }
        }

        return true;
    }

    private boolean isStrDec(int[] nums, int start, int end) {
        if(end - start < 1) return false;
        
        for(int i=start; i<end; i++) {
            if(nums[i] <= nums[i+1]) {
                return false;
            }
        }

        return true;
    }
}