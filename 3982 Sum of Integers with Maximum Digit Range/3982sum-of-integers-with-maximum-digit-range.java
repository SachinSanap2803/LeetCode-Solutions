class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            int num = nums[i];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            while(num > 0) {
                int last = num % 10;
                max = Math.max(max, last);
                min = Math.min(min, last);
                num /= 10;
            }

            arr[i] = max - min;
        }

        int maxi = 0;
        
        for(int x : arr) {
            maxi = Math.max(maxi, x);
        }

        int sum = 0;

        for(int i=0; i<n; i++) {
            if(arr[i] == maxi) {
                sum += nums[i];
            }
        }

        return sum;
    }
} 