class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int digitSum = 0;
        int digitProduct = 1;

        while(n > 0) {
            int rem = n % 10;

            digitSum += rem;
            digitProduct *= rem;

            n /= 10;
        }

        int totalSum = digitSum + digitProduct;

        return num % totalSum == 0;
    }
} 