class Solution {
    public int scoreDifference(int[] nums) {
        int firstPlayer = 0;
        int secondPlayer = 0;

        boolean firstActive = true;

        for(int i=0; i<nums.length; i++) {
            
            if(nums[i] % 2 == 1) {
                firstActive = !firstActive;
            }

            if((i+1) % 6 == 0) {
                firstActive = !firstActive;
            }

            if(firstActive) {
                firstPlayer += nums[i];
            } else {
                secondPlayer += nums[i];
            }
        }

        return firstPlayer - secondPlayer;
    }
} 