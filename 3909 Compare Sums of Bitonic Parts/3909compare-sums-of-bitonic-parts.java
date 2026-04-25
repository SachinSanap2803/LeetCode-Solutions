class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        int peak = 0;

        for(int i=1; i<n; i++) {
            if(nums[i] > nums[i-1]) {
                peak = i;
            } else {
                break;
            }
        }

        long inc = 0, dec = 0;

        for(int i=0; i<=peak; i++) {
            inc += nums[i];
        }

        for(int i=peak; i<n; i++) {
            dec += nums[i];
        }

        if(inc > dec) return 0;
        else if(inc < dec) return 1;
        else return -1;
    }
} 