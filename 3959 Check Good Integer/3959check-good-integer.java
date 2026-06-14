class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int sqSum = 0;

        while(n > 0) {
            int rem = n % 10;
            digitSum += rem;
            sqSum += (rem * rem);
            n /= 10;
        }

        return sqSum - digitSum >= 50;
    }
} 