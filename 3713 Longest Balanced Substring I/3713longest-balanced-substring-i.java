class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            int[] freq = new int[26];
            for(int j=i; j<n; j++) {
                int idx = s.charAt(j) - 'a';
                freq[idx]++;

                int minF = Integer.MAX_VALUE;
                int maxF = 0;

                for(int k=0; k<26; k++) {
                    if(freq[k] > 0) {
                        minF = Math.min(minF, freq[k]);
                        maxF = Math.max(maxF, freq[k]);
                    }
                }

                if(minF == maxF) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }
} 