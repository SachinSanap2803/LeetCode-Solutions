class Solution {
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int MaxAltitude = 0;
        int n = gain.length;

        for(int i=0; i<n; i++) {
            prefixSum += gain[i];
            MaxAltitude = Math.max(MaxAltitude, prefixSum);
        }

        return MaxAltitude;
    }
} 