class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int count = 0, oddCnt = 0, evenCnt = 0;

        for(int i=0; i<n; i++) {
            oddCnt = 0; evenCnt = 0;
            for(int j=i; j<n; j++) {
                if(nums[j] % 2 == 0) {
                    evenCnt++;
                } else {
                    oddCnt++;
                }

                if(oddCnt == 0) continue;

                if((1L * evenCnt * b) <= (1L * oddCnt * a)) {
                    count++;
                }
            }
        }

        return count;
    }
} 