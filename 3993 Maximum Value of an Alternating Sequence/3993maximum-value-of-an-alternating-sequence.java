class Solution {
    public long maximumValue(int n, int s, int m) {
        long evenPeaks = (n+1L) / 2;
        long oddPeaks = n / 2L;

        long ans1 = (long) s + (evenPeaks - 1) * (m - 1L);

        long ans2;
        if(oddPeaks == 0) {
            ans2 = s;
        } else {
            ans2 = (long) s + m + (oddPeaks - 1) * (m - 1L);
        }

        return Math.max(ans1, ans2);
    }
} 