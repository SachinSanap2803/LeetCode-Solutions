class Solution {
    public int countSetBits(int n) {
        int setBits = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                setBits++;
            }

            n >>= 1;
        }

        return setBits;
    }

    public boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for(int i = left; i <= right; i++) {
            int n = countSetBits(i);

            if(isPrime(n)) {
                count++;
            }
        }

        return count;
    }
} 