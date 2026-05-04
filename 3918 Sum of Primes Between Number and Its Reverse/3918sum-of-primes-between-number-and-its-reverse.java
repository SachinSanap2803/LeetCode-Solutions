class Solution {
    public int sumOfPrimesInRange(int n) {
        int n1 = n;
        int n2 = rev(n);

        int sum = 0;

        int min = Math.min(n1, n2);
        int max = Math.max(n1, n2);

        for(int i=min; i<=max; i++) {
            if(i < 2) continue;
            
            boolean isPrime = true;
            for(int j=2; j*j<=i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                sum += i;
            }
        }

        return sum;
    }

    public int rev(int n) {
        int num = 0;
        while(n > 0) {
            int rem = n % 10;
            num = num * 10 + rem;
            n /= 10;
        }

        return num;
    }
} 