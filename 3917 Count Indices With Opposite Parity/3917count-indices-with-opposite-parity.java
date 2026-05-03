class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i=0; i<n-1; i++) {
            int count = 0;

            for(int j=i+1; j<n; j++) {
                if((nums[i] % 2 == 0 && nums[j] % 2 == 1) || (nums[i] % 2 == 1 && nums[j] % 2 == 0)) {
                    count++;
                }
            }

            res[i] = count;
        }

        res[n-1] = 0;

        return res;
    }
} 