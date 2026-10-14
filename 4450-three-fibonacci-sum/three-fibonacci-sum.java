class Solution {
    public boolean threeFibonacciSum(int n) {
        if(n % 2 != 0) return false;

        int target = n / 2;
        int first = 0;
        int second = 1;

        while(first < target) {
            int third = first + second;
            first = second;
            second = third;
        }

        return first == target;
    }
} 