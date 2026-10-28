class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long[] gain = new long[n];

        for(int i=0; i<n; i++) {
            sum += nums[i];

            long best = maxRearranged(nums[i]);
            gain[i] = best - nums[i];
        }

        Arrays.sort(gain);

        for(int i=n-1; i>=n-k; i--) {
            sum += gain[i];
        }

        return sum;
    }

    private long maxRearranged(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);

        int left = 0, right = digits.length-1;

        while(left < right) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;

            left++;
            right--;
        }

        return Long.parseLong(new String(digits));
    }
} 