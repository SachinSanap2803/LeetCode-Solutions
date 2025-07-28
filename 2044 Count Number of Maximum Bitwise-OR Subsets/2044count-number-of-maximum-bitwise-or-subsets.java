class Solution {
    private int count = 0;
    private int maxOR = 0;

    public int countMaxOrSubsets(int[] nums) {

        // Maximum OR of all subsets is always the OR of all elements
        for(int num : nums) {
            maxOR |= num;
        }

        generateSubsets(nums, 0, 0);

        return count;
    }

    public void generateSubsets(int[] nums, int idx, int currOR) {
        if(idx == nums.length) {
            if(currOR == maxOR) {
                count++;
            }
            return;
        }

        generateSubsets(nums, idx+1, currOR | nums[idx]);

        generateSubsets(nums, idx+1, currOR);
    }
}