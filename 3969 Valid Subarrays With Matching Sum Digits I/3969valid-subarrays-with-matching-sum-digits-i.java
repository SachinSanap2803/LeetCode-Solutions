class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;

        for(int i=0; i<n; i++) {
            long sum = 0;
            for(int j=i; j<n; j++) {
                sum += nums[j];

                long num = sum;

                int last = (int) (num % 10);

                while(num >= 10) {
                    num = num / 10;
                }

                int first = (int) num;

                if(first == x && last == x) {
                    count++;
                }

                // String str = sum + "";

                // if(str.charAt(0) - '0' == x && str.charAt(str.length() - 1) - '0' == x) {
                //     count++;
                // }
            }
        }

        return count;
    }
} 