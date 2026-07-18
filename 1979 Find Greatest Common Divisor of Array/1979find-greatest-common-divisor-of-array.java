class Solution {
    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public int findGCD(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];

        for(int i=1; i<nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }

        return gcd(smallest, largest);
    }
} 