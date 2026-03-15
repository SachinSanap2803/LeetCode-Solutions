class Solution {
    public int countCommas(int n) {
        long start = 1000;
        int commas = 1;
        long ans = 0;

        while(start <= n) {
            ans += (n - start + 1) * commas;
            start *= 1000;
            commas++;
        }

        return (int) ans;
    }
} 