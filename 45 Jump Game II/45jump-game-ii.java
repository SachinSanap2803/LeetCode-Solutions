class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int maxIdx = 0;
        int currIdx = 0;

        for(int i=0; i<nums.length-1; i++) {
            maxIdx = Math.max(maxIdx, i + nums[i]);

            if(i == currIdx) {
                count++;
                currIdx = maxIdx;
            }
        }

        return count;
    }
} 