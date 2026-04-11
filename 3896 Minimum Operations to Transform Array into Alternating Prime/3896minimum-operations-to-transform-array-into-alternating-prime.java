class Solution {

    private boolean isPrime(int n) {
        if(n < 2) return false;

        for(int i=2; i*i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;

        for(int i=0; i<n; i++) {
            int num = nums[i];

            if(i % 2 == 0) {
                // need Prime number
                while(!isPrime(num)) {
                    ops++;
                    num++;
                }
            } else {
                // need Non Prime number
                while(isPrime(num)) {
                    ops++;
                    num++;
                }
            }
        }

        return ops;
    }
} 