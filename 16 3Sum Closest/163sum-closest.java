class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<n-2; i++) {
            int j = i+1;
            int k = n-1;

            while(j < k) {
                int currSum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - currSum) < Math.abs(target - closestSum)) {
                    closestSum = currSum;
                }

                if(currSum < target) {
                    j++;
                } else if(currSum > target) {
                    k--;
                } else {
                    return closestSum;
                }
            }
        }

        return closestSum;
    }
} 