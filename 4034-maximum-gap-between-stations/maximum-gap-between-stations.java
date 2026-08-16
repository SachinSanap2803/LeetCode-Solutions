class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();

        int[] left = new int[n];
        int j = 0;    // Earliest possible position

        for(int i=0; i<n; i++) {
            while(station.charAt(j) != skill.charAt(i)) {
                j++;
            }

            left[i] = j;
            j++;
        }

        int ans = 0;
        j = m-1;    // Latest possible position for current worker

        for(int i=n-1; i>=1; i--) {
            while(station.charAt(j) != skill.charAt(i)) {
                j--;
            }

            ans = Math.max(ans, j - left[i-1]);
            j--;
        }

        return ans;
    }
} 