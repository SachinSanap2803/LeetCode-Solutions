class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;
        int n = nums1.length;

        for(int i=0; i<n; i++) {
            if(nums1[i] % 2 == 1) {
                hasOdd = true;
                minOdd = Math.min(minOdd, nums1[i]);
            }
        }

        // All even
        if(!hasOdd) {
            return true;
        }

        for(int num : nums1) {
            if(num % 2 == 0 && num < minOdd) {
                return false;
            }
        }

        return true;
    }
} 