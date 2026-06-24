class Solution {
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
    
    public int findLCM(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int currLCM = 0;

        for(int i=0; i<n; i++) {
            currLCM = nums[i];

            for(int j=i; j<n; j++) {
                currLCM = findLCM(currLCM, nums[j]);

                if(currLCM == k) count++;
                if(currLCM > k) break;
            }
        }

        return count;
    }
}  